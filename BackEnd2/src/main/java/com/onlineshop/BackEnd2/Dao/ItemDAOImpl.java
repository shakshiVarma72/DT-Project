package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import com.onlineshop.BackEnd2.dto.Item;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	@Repository("itemDao")
	@Transactional
	public class ItemDAOImpl implements ItemDao {

		@Autowired
		ItemDao itemDao;
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return sessionFactory.getCurrentSession();
		}
		
		public boolean addItem(Item item) {
			try{
			Session session=getSession();
			session.save(item);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}

		public boolean updateItem(Item item) {
			try{
			Session session=getSession();
			session.update(item);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}

		public Item getItemByProductIdAndCustomerId(int productid, String customerId) {
			try{
			Session session=getSession();
			Query query=session.createQuery
			("from com.onlineshop.BackEnd2.dto.Item where product.productId=:pid and customerId=:cId");
			query.setParameter("pid",productid);
			query.setParameter("cId","customerId");
			@SuppressWarnings("unchecked")
			List<Item> items=query.list();
			return items.get(0);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

		public List<Item> getItemsListByCart(int cartId) {
			Session session = getSession();
			try{
				String hql = "From com.onlineshop.BackEnd2.dto.Item where cart_cartid = :cartId";
				Query query = session.createQuery(hql);
				query.setParameter("cartId", cartId);
				List<Item> results = (List<Item>)query.list();
				return results;
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				return null;
			}
		}

		public boolean increaseQuantity(int itemId) {
			Session session = sessionFactory.getCurrentSession();
			try{
				Item item = (Item)session.get(Item.class, itemId);
				item.setQuantity(item.getQuantity()+1);
				session.update(item);
				return true;
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				return false;
			}
		}

		public boolean decreaseQuantity(int itemId) {
			Session session = sessionFactory.getCurrentSession();
			try{
				Item item=(Item)session.get(Item.class, itemId);
				item.setQuantity(item.getQuantity()-1);
				session.update(item);
				return true;
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				return false;
			}
			
		}

		public boolean deleteItem(int itemId) {
			Session session = sessionFactory.getCurrentSession();
			try{
				Item item = (Item)session.get(Item.class,itemId);
				
				session.delete(item);
				return true;
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				return false;
			}
		}
		

	}
