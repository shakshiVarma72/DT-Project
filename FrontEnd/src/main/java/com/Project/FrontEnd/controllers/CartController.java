package com.Project.FrontEnd.controllers;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.BackEnd2.Dao.AddressDao;
import com.onlineshop.BackEnd2.Dao.CartDao;
import com.onlineshop.BackEnd2.Dao.ItemDao;
import com.onlineshop.BackEnd2.Dao.OrderDao;
import com.onlineshop.BackEnd2.Dao.ProductDao;
import com.onlineshop.BackEnd2.Dao.UserDao;
import com.onlineshop.BackEnd2.dto.Address;
import com.onlineshop.BackEnd2.dto.Cart;
import com.onlineshop.BackEnd2.dto.Item;
import com.onlineshop.BackEnd2.dto.Order;
import com.onlineshop.BackEnd2.dto.Product;
import com.onlineshop.BackEnd2.dto.User;


@Controller
public class CartController {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	ProductDao productDao;
	
	
@RequestMapping(value="/addToCart/{productId}",method=RequestMethod.GET)
	public String addToCart(@PathVariable("productId")int productId)
	{
		System.out.println("I m addToCart method");
		Principal principal = request.getUserPrincipal();
		String userEmail=principal.getName();
		
		System.out.println("User Email = "+userEmail);
		
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		
		if(cartObj==null){
			System.out.println("Cart Obj is null");
		
			Cart cart=new Cart();
			System.out.println("I m here 1");
			cart.setCustomerId(userEmail);
			
			System.out.println("I m here 2");
			cart.setUser(userDao.getUserByEmail(userEmail));
			cartDao.addCart(cart);
			
			System.out.println("I m here 3");
			
			Item item=new Item();
			item.setCart(cartDao.getCartByCustomer(userEmail));
			item.setCustomerId(userEmail);
			item.setPrice(productDao.getProductById(productId).getPrice());
			item.setProduct(productDao.getProductById(productId));
			item.setQuantity(1);
			
			System.out.println("I m here 2");
			ArrayList<Item> al=new ArrayList<>();
			al.add(item);
			cart.setItems(al);
			
			
			itemDao.addItem(item);
			System.out.println("Cart Created Succesfully");
			
		}
		else {
			
			System.out.println("Cart is available");
			Product pro=productDao.getProductById(productId);
			
			Item itemObj=itemDao.getItemByProductIdAndCustomerId(productId, userEmail);
			if(itemObj==null){
				System.out.println("New Item");
				Item item=new Item();
				item.setCart(cartObj);
				item.setCustomerId(userEmail);
				item.setPrice(pro.getPrice());
				item.setProduct(pro);
				item.setQuantity(1);
				
				itemDao.addItem(item);
				System.out.println("Item Object added into existing cart");
				
			}
			else {
				itemDao.increaseQuantity(itemObj.getItemId());
			}
			
		}
		return "redirect:viewCart?uEmail="+userEmail;
	}
	@RequestMapping(value="/addToCart/viewCart",method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("uEmail")String uEmail)
	{
		System.out.println("uEmail = "+uEmail);
		ModelAndView mv=new ModelAndView("viewCart");
		Cart cartObj=cartDao.getCartByCustomer(uEmail);
		System.out.println("Cart Obj : "+cartObj );
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		for(Item i:items){
			if(i.getQuantity()==0){
				itemDao.deleteItem(i.getItemId());
				items=itemDao.getItemsListByCart(cartObj.getCartId());
			}
		}
		
		mv.addObject("itemsList",items);
		return mv;
	}
	
	@RequestMapping(value="/addToCart/deleteItem/{iId}",method=RequestMethod.GET)
	public ModelAndView deleteFromCart(@PathVariable("iId")int itemId){
		
		itemDao.deleteItem(itemId);
		
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("viewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Item deleted");
		return mv;
	}
	@RequestMapping(value="/addToCart/increaseQuantity/{iId}",method=RequestMethod.GET)
	public ModelAndView increaseQuantity(@PathVariable("iId")int itemId){
		
		itemDao.increaseQuantity(itemId);
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("ViewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Quantity Increased");
		return mv;
	}
	@RequestMapping(value="/addToCart/decreaseQuantity/{iId}",method=RequestMethod.GET)
	public ModelAndView decreaseQuantity(@PathVariable("iId")int itemId){
		
		itemDao.decreaseQuantity(itemId);
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("viewCart");
		mv.addObject("itemsList",items);
		mv.addObject("msg","Quantity decreased");
		return mv;
	}
	
	@RequestMapping(value="/addToCart/makePayment",method=RequestMethod.GET)
	public ModelAndView addressForm(){
		
		String id=request.getUserPrincipal().getName();
		System.out.println("Id = "+id);
		User user=userDao.getUserByEmail(id);
		System.out.println("User ="+user);
		
		Set<Address> addresses=user.getAddresses();
		
		
		
		if(addresses.isEmpty()){
			ModelAndView mv=new ModelAndView("AddressForm");
			mv.addObject("addressObj",new Address());
			return mv;
		}
		else {
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		}
	}
	@RequestMapping(value="/addToCart/addAddress",method=RequestMethod.POST)
	public ModelAndView addAddress(@ModelAttribute("addressObj")Address addrObj){
		
		String id=request.getUserPrincipal().getName();
		User user=userDao.getUserByEmail(id);
	
		addrObj.setUser(userDao.getUserByEmail(id));
		
		addressDao.insertAddress(addrObj);
		
		Set<Address> addresses=user.getAddresses();
		
		
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		
	}
	
	@RequestMapping(value="/addToCart/placeOrder",method=RequestMethod.GET)
	public ModelAndView makePayment(){
		
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
		
		ModelAndView mv=new ModelAndView("OrderConfirmation");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		return mv;
	}

	@RequestMapping(value="/addToCart/confirmOrder",method=RequestMethod.GET)
	public ModelAndView confirmOrder(){
		Principal p=request.getUserPrincipal();
		Cart cartObj=cartDao.getCartByCustomer(p.getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
	
		ModelAndView mv=new ModelAndView("PaymentForm");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		Order o=new Order();
		o.setTotalPrice(sum);
		
		List<Address> addrList=new ArrayList<>(userDao.getUserByEmail(p.getName()).getAddresses());
		o.setAddress(addrList.get(0));
		
		o.setUser(userDao.getUserByEmail(p.getName()));
		mv.addObject("orderObj",o);
		return mv;
	}

	@RequestMapping(value="/addToCart/processOrder",method=RequestMethod.POST)
	public ModelAndView processOrder(@ModelAttribute("orderObj")Order orderObj){
		String email=request.getUserPrincipal().getName();
	
		Cart cartObj=cartDao.getCartByCustomer(email);
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
		
		orderDao.makeOrder(orderObj);
		cartDao.deleteCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("PaymentSuccess");
		mv.addObject("totalAmountToPay",sum);
		return mv;
	
	
}






}