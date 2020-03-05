package org.learn.store.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class CartStatusWebResponse {

	
	public String statusCode;
	public String statusHistory;
	public String state;
	
	@JsonInclude(Include.NON_EMPTY)
	public List<Error> errors;
	public OrderDetails orderDetails;
	
	public static class OrderDetails {
		public long orderNumber;

		@JsonInclude(Include.NON_EMPTY)
		public List<Error> errors;
	}
	
	@JsonInclude(Include.NON_NULL)
	public static class Error {
		public String message;
		public String code;
	}
}
