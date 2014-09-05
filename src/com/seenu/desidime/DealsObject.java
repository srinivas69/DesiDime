package com.seenu.desidime;

import java.util.ArrayList;

public class DealsObject {

	private String errorcode;
	private String errorstr;
	private Result result;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrorstr() {
		return errorstr;
	}

	public void setErrorstr(String errorstr) {
		this.errorstr = errorstr;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class Result {

		private ArrayList<Top> top;

		public Result() {
			// TODO Auto-generated constructor stub
			top = new ArrayList<Top>();
		}

		public ArrayList<Top> getTop() {
			return top;
		}

		public void setTop(ArrayList<Top> top) {
			this.top = top;
		}

		public static class Top {

			private String id;
			private String title;
			private String off_percent;
			private String store;
			private String current_price;
			private String original_price;
			private String shipping_charge;
			private String posted_user_id;
			private String store_url;
			private String shareurl;
			private String posted_username;
			private String popularity_count;
			private String comments_count;
			private String deal_detail;
			private String posted_user_current_dimes;
			private String posted_user_image;
			private String posted_user_rank;
			private String deal_category_name;
			private String deal_category_id;
			private String created_at;
			private String pic_thumb;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getOff_percent() {
				return off_percent;
			}

			public void setOff_percent(String off_percent) {
				this.off_percent = off_percent;
			}

			public String getStore() {
				return store;
			}

			public void setStore(String store) {
				this.store = store;
			}

			public String getCurrent_price() {
				return current_price;
			}

			public void setCurrent_price(String current_price) {
				this.current_price = current_price;
			}

			public String getOriginal_price() {
				return original_price;
			}

			public void setOriginal_price(String original_price) {
				this.original_price = original_price;
			}

			public String getShipping_charge() {
				return shipping_charge;
			}

			public void setShipping_charge(String shipping_charge) {
				this.shipping_charge = shipping_charge;
			}

			public String getPosted_user_id() {
				return posted_user_id;
			}

			public void setPosted_user_id(String posted_user_id) {
				this.posted_user_id = posted_user_id;
			}

			public String getStore_url() {
				return store_url;
			}

			public void setStore_url(String store_url) {
				this.store_url = store_url;
			}

			public String getShareurl() {
				return shareurl;
			}

			public void setShareurl(String shareurl) {
				this.shareurl = shareurl;
			}

			public String getPosted_username() {
				return posted_username;
			}

			public void setPosted_username(String posted_username) {
				this.posted_username = posted_username;
			}

			public String getPopularity_count() {
				return popularity_count;
			}

			public void setPopularity_count(String popularity_count) {
				this.popularity_count = popularity_count;
			}

			public String getComments_count() {
				return comments_count;
			}

			public void setComments_count(String comments_count) {
				this.comments_count = comments_count;
			}

			public String getDeal_detail() {
				return deal_detail;
			}

			public void setDeal_detail(String deal_detail) {
				this.deal_detail = deal_detail;
			}

			public String getPosted_user_current_dimes() {
				return posted_user_current_dimes;
			}

			public void setPosted_user_current_dimes(
					String posted_user_current_dimes) {
				this.posted_user_current_dimes = posted_user_current_dimes;
			}

			public String getPosted_user_image() {
				return posted_user_image;
			}

			public void setPosted_user_image(String posted_user_image) {
				this.posted_user_image = posted_user_image;
			}

			public String getPosted_user_rank() {
				return posted_user_rank;
			}

			public void setPosted_user_rank(String posted_user_rank) {
				this.posted_user_rank = posted_user_rank;
			}

			public String getDeal_category_name() {
				return deal_category_name;
			}

			public void setDeal_category_name(String deal_category_name) {
				this.deal_category_name = deal_category_name;
			}

			public String getDeal_category_id() {
				return deal_category_id;
			}

			public void setDeal_category_id(String deal_category_id) {
				this.deal_category_id = deal_category_id;
			}

			public String getCreated_at() {
				return created_at;
			}

			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			public String getPic_thumb() {
				return pic_thumb;
			}

			public void setPic_thumb(String pic_thumb) {
				this.pic_thumb = pic_thumb;
			}

		}

	}

}
