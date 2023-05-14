package fr.emile.jsfsix.entity;

import java.sql.ResultSet;
import java.util.Date;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.enums.DeliveryMethod;
import fr.emile.jsfsix.enums.OrderStatus;
import fr.emile.jsfsix.model.dao.AddressDao;
import fr.emile.jsfsix.model.dao.BankCardDao;
import fr.emile.jsfsix.model.dao.IAddressDao;
import fr.emile.jsfsix.model.dao.IBankCardDao;
import fr.emile.jsfsix.utils.Utils;

public class Order implements IConstant {
	//---------------attribut ---------------------
		private int id;
		private int number;
		private Date createDate;
		private Date deliveryDate;
		private Date cancellationDate;
		private DeliveryMethod deliveryMethod;
		private Address deliveryAddress;
		private Address billingAddress;
		private BankCard bankCardUsed;
		private OrderStatus status;
		private int userId;
		private boolean isDeleted;

		// ------------------------ constructor --------------
		/**
		 * @param id
		 * @param number
		 * @param createDate
		 * @param deliveryDate
		 * @param cancellationDate
		 * @param deliveryMethod
		 * @param deliveryAddressId
		 * @param billingAddressId
		 * @param bankCardUsedId
		 * @param status
		 * @param userId
		 */
		public Order(int id, int number, Date createDate, Date deliveryDate, Date cancellationDate,
				DeliveryMethod deliveryMethod, Address deliveryAddress, Address billingAddress, BankCard bankCardUsed,
				OrderStatus status, boolean isDeleted,int userId) {
			this.setId(id);
			this.setNumber(number);
			this.setCreateDate(createDate);
			this.setDeliveryDate(deliveryDate);
			this.setCancellationDate(cancellationDate);
			this.setDeliveryMethod(deliveryMethod);
			this.setDeliveryAddress(deliveryAddress);
			this.setBillingAddress(billingAddress);
			this.setBankCardUsed(bankCardUsed);
			this.setStatus(status);
			this.setDeleted(isDeleted);
			this.setUserId(userId);

		}

		public Order() {

			this(DEFAULT_ID, DEFAULT_ID, NULL_DATE, NULL_DATE, NULL_DATE, DEFAULT_DELIVERY, NULL_ADDRESS, NULL_ADDRESS,
					NULL_BANKCARD, DEFAULT_STATUS,DEFAULT_IS_DELETE, DEFAULT_ID);

		}


		public Order(ResultSet resultSet) throws Exception {

			this (resultSet.getInt("id"),
					resultSet.getInt("number"),
					Utils.toJavaDate(resultSet.getDate("create_date")),
					Utils.toJavaDate(resultSet.getDate("delivery_date")),
					Utils.toJavaDate(resultSet.getDate("cancellation_date")),
					DeliveryMethod.fromString(resultSet.getString("delivery_methode")),
					NULL_ADDRESS,NULL_ADDRESS,NULL_BANKCARD,
					OrderStatus.fromString(resultSet.getString("status")),
					resultSet.getBoolean("is_deleted"),
					resultSet.getInt("user_id")
					);


		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(Date deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public Date getCancellationDate() {
			return cancellationDate;
		}

		public void setCancellationDate(Date cancellationDate) {
			this.cancellationDate = cancellationDate;
		}

		public DeliveryMethod getDeliveryMethod() {
			return deliveryMethod;
		}

		public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
			this.deliveryMethod = deliveryMethod;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Address getDeliveryAddress() {
			return deliveryAddress;
		}

		public void setDeliveryAddress(Address deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}

		public Address getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
		}

		public BankCard getBankCardUsed() {
			return bankCardUsed;
		}

		public void setBankCardUsed(BankCard bankCardUsed) {
			this.bankCardUsed = bankCardUsed;
		}

		public boolean isDeleted() {
			return isDeleted;
		}

		public void setDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}

		@Override
		public String toString() {
			final IBankCardDao myBankCardDao = new BankCardDao();
			final IAddressDao myAddressDao = new AddressDao();
			String stringReturn = "";
//			Address deliveryAdress = new Address();
//
//			Address billingAdress = new Address();
//			BankCard bankCard = new BankCard();

			try {
				stringReturn += String.format("id:%s order-number :%010d, create %s, ", this.getId(), this.getNumber(),
						Utils.date2String(this.getCreateDate(), "dd/MM/yyyy"));

				stringReturn += String.format("%s", this.getDeliveryDate() == null ? ""
						: "delivery : " + Utils.date2String(this.getDeliveryDate(), "dd/MM/yyyy"));

				stringReturn += String.format("%s", this.getCancellationDate() == null ? ""
						: " Cancel : " + Utils.date2String(this.getCancellationDate(), "dd/MM/yyyy"));

				stringReturn += String.format(" by %s  {%s} isDeleted : %b\n",
						this.getDeliveryMethod().getValue(), this.getStatus(),this.isDeleted());

				stringReturn += String.format(" \t\t delivery address %s\n",this.getDeliveryAddress().toString());
				stringReturn += String.format(" \t\t billing address %s\n",
						this.getBillingAddress()).toString();
				stringReturn += String.format(" \t\t Bank card %s\n",
						this.getBankCardUsed()).toString();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return stringReturn;

		}
}
