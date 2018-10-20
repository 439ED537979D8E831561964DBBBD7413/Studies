package in.co.khuranasales.khuranasales;

/**
 * Created by Ankush khurana on 7/30/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;

public class AppConfig {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static String PREF_NAME = "Khurana_sales_pref";

    public AppConfig(Context context)
    {
     int private_mode = 0;
     pref = context.getSharedPreferences(PREF_NAME,private_mode);
     editor = pref.edit();
     editor.commit();
    }

    public Boolean isLogin()
    {
        return  pref.getBoolean("status_login",false);
    }

    public void setFirebaseId(String id)
    {
     editor.putString("firebase_id",id);
     editor.commit();
    }

    public String getFirebaseId()
    {
       return pref.getString("firebase_id","MyFirebaseId");
    }
    public void setStatus_login(Boolean status_login)
    {
        editor.putBoolean("status_login",status_login);
        editor.commit();
    }

    public void setUser_name(String user_name) {
        editor.putString("user_name",user_name);
        editor.commit();
    }

    public void setUser_outstanding(String outstanding)
    {
        editor.putString("user_outstanding",outstanding);
        editor.commit();
    }

    public String getUser_outstanding()
    {
        return pref.getString("user_outstanding","0");
    }
    public String getUser_name() {
        return pref.getString("user_name","Ankush Khurana");
    }

    public void setUser_email(String user_email)
    {
        editor.putString("user_email",user_email);
        editor.commit();
    }

    public String getUser_email() {
        return pref.getString("user_email","ankushkhurana34@gmail.com");
    }

    public void setUser_shop_name(String user_shop_name)
    {
        editor.putString("user_shop_name",user_shop_name);
        editor.commit();
    }

    public String getUser_shop_name() {
     return   pref.getString("user_shop_name","Khurana Sales");
    }

    public void setUserType(String user_type)
    {
        editor.putString("user_type",user_type);
        editor.commit();
    }

    public String getUserType() {
        return pref.getString("user_type","Promoter");
    }

    public void setCustomer_id(Integer customer_id)
    {
        editor.putInt("customer_id",customer_id);
        editor.commit();
    }

    public Integer getCustomer_id() {
        return pref.getInt("customer_id",0);
    }

    public static String ip = "172.20.10.4";
    public static int product_count = 0;
    public static Integer customer_id = 0;
    public static int CGST = 6;
    public static int SGST = 6;
    public static String url_register = "http://khuranasales.co.in/work/register.php";
    public static String url_login = "http://khuranasales.co.in/work/login.php";
    public static String url_product_view = "http://khuranasales.co.in/work/get_products.php?brand=";
    public static String url_price_update = "http://khuranasales.co.in/work/changePrice.php";
    public static String url_product_stock_check = "http://khuranasales.co.in/work/count.php?product_id=";
    public static String url_address_list = "http://khuranasales.co.in/work/get_addresses.php?customer_id=";
    public static String url_add_address = "http://khuranasales.co.in/work/add_address.php?customer_id=";
    public static String url_set_bought = "http://khuranasales.co.in/work/set_order_bought.php?email=";
    public static String url_set_viewed = "http://khuranasales.co.in/work/add_product.php";
    public static String url_get_viewed = "http://khuranasales.co.in/work/get_viewed.php?email=";
    public static String url_get_bought = "http://khuranasales.co.in/work/get_bought.php?email=";
    public static String url_delete_viewed = "http://khuranasales.co.in/work/delete_viewed.php?";
    public static String url_decrement_viewed = "http://khuranasales.co.in/work/decrement_viewed.php?";
    public static String url_increment_viewed = "http://khuranasales.co.in/work/increment_viewed.php?";
    public static String url_load_coupons = "http://khuranasales.co.in/work/get_coupons.php";
    public static String url_load_count = "http://khuranasales.co.in/work/get_person_in_cart_count.php?email=";
    public static String url_generate_invoice = "http://khuranasales.co.in/work/invoice.php";
    public static String url_customer_info_update = "http://khuranasales.co.in/work/update_order_customer_info.php";
    public static String url_all_users_access = "http://khuranasales.co.in/work/get_users.php";
    public static String url_update_access = "http://khuranasales.co.in/work/update_user_permission.php?";
    public static String url_search = "http://khuranasales.co.in/work/get_products_searched.php?search=";
    public static String url_categories = "http://khuranasales.co.in/work/get_categories.php";
    public static String url_firebase_id = "http://khuranasales.co.in/work/update_firebase_id.php";
    public static String url_send_notifications  = "http://khuranasales.co.in/work/firebase_index.php";
    public static String url_get_promoters_sold_products = "http://khuranasales.co.in/work/get_promoters_sold.php?";
    public static String update_order_status = "http://khuranasales.co.in/work/update_order_status.php?order_number=";
    public static String get_promoters = "http://khuranasales.co.in/work/get_promoter_names.php";
    public static String filtered_promoters = "http://khuranasales.co.in/work/get_filtered_promoter_sold.php";
    public static String upload_payment = "http://khuranasales.co.in/work/upload_payment_with_credit.php";
    public static String get_banks_or_financers = "http://khuranasales.co.in/work/get_banks_financers.php?info=";
    public static String upload_batches = "http://khuranasales.co.in/work/upload_batches.php";
    public static String load_product_names_search = "http://khuranasales.co.in/work/get_product_names.php?search=";
    public static String load_single_product_by_id = "http://khuranasales.co.in/work/fetch_single_product.php?product_id=";
    public static String check_availability_order = "http://khuranasales.co.in/work/check_products_availability.php?email=";
    public static String get_invoice_data_reinvoice = "http://khuranasales.co.in/work/get_products_reinvoice.php?sales_order_invoice_number=";
    public static String add_to_favorites = "http://khuranasales.co.in/work/add_to_favorites.php?product_id=";
    public static String remove_from_favorites = "http://khuranasales.co.in/work/remove_from_favorites.php?product_id=";
    public static String get_favorites = "http://khuranasales.co.in/work/get_favorites.php?email=";
    public static String get_offers = "http://khuranasales.co.in/work/get_offers.php";
    public static String add_offer = "http://khuranasales.co.in/work/add_offer.php";
    public static String delete_offer = "http://khuranasales.co.in/work/delete_offer.php?product_id=";
    public static String get_best_sellings = "http://khuranasales.co.in/work/get_best_selling.php";
    public static String get_new_launches = "http://khuranasales.co.in/work/get_new_launches.php";
    public static String load_ledgers = "http://khuranasales.co.in/work/get_ledgers.php?search=";
    public static String get_product_by_ids_combo_offer = "http://khuranasales.co.in/work/get_products_by_ids.php?ids=";
    public static String upload_offers_product = "http://khuranasales.co.in/work/upload_offered_product.php?";
    public static String get_service_centers_url = "http://khuranasales.co.in/work/get_service_centers.php";
    public static String search_service_center_url = "http://khuranasales.co.in/work/search_service_centers.php?search=";
    public static String load_promoters_url = "http://khuranasales.co.in/work/get_promoter_names.php";
    public static String load_promoters_orders = "http://khuranasales.co.in/work/get_product_sold_promoters_export.php";
    public static String load_products_by_multiple_brands = "http://khuranasales.co.in/work/get_stock_export.php";
    public static String load_products_with_batch = "http://khuranasales.co.in/work/get_products_with_batch_export.php";
    public static String url_payment_export = "http://khuranasales.co.in/work/get_payment_export.php";
    public static String url_load_offers_filtered_by_product_id = "http://khuranasales.co.in/work/get_filtered_offers.php?product_id=";
    public static String url_load_profile = "http://khuranasales.co.in/work/get_profile_details.php?email=";
    public static String url_update_profile = "http://khuranasales.co.in/work/update_user_profile.php";
    public static String load_product_with_offer_details = "http://khuranasales.co.in/work/get_products_with_offer_detail.php?brand=";
    public static String load_offers_filtered = "http://khuranasales.co.in/work/get_offers_filtered.php?product_id=";
    public static String update_offer = "http://khuranasales.co.in/work/update_offer.php";
    public static String load_access_types = "http://khuranasales.co.in/work/get_access_types.php";
    public static String search_products_with_offers = "http://khuranasales.co.in/work/get_products_searched_with_offer_detail.php?search=";
    public static String set_bought_with_update_batch_locations = "http://khuranasales.co.in/work/set_order_bought_wiith_batch_locations.php?email=";
    public static String cancel_order = "http://khuranasales.co.in/work/cancel_order.php?order_no=";
    public static String url_set_re_bought = "http://khuranasales.co.in/work/set_re_bought.php?order_no=";
    public static String load_outstanding_amount = "http://khuranasales.co.in/work/get_outstanding_amount.php?promoter_email=";
    public static String block_user = "http://khuranasales.co.in/work/block_user.php?email=";
    public static String search_bank = "http://khuranasales.co.in/work/get_banks_searched.php?search=";
    public static String load_batch_locations ="http://khuranasales.co.in/work/load_batch_locations.php";
    public static String get_product_export_with_batch_locations = "http://khuranasales.co.in/work/get_product_export_with_batch_locations.php";
    public static String add_service_center_url = "http://khuranasales.co.in/work/add_new_service_center.php";
    public static String delete_service_center_url = "http://khuranasales.co.in/work/delete_service_center.php?service_center_id=";
    public static String update_service_center_url = "http://khuranasales.co.in/work/update_service_center.php";
    public static String add_purchase_product_url = "http://khuranasales.co.in/work/insert_new_purchase_product.php";
    public static String update_purchase_product_url = "http://khuranasales.co.in/work/update_purchase_product.php";
    public static String get_uploaded_purchased_products = "http://khuranasales.co.in/work/get_uploaded_purchased_products.php";
    public static String set_bought_with_batch_locations_and_purchase_check = "http://khuranasales.co.in/work/set_bought_with_dealers_check_and_batch_locations.php?email=";
    public static String url_set_re_bought_with_dealer_check = "http://khuranasales.co.in/work/set_re_bought_with_dealer_check.php?order_no=";
    public static String cancel_order_with_dealer_check = "http://khuranasales.co.in/work/cancel_order_with_dealer_check.php?order_no=";
    public static String get_scanned_product_details = "http://khuranasales.co.in/work/search_product_by_batch.php?batch=";
    public static String copy_offer_url = "http://khuranasales.co.in/work/copy_offer_to_other_products.php";
    public static String get_copied_offer_products_url = "http://khuranasales.co.in/work/get_copied_offer_products.php?offer_id=";
    public static String delete_copied_offer = "http://khuranasales.co.in/work/delete_copied_offer.php?offer_id=";
    public static String get_batches_locations_by_batch_numbers = "http://khuranasales.co.in/work/get_batches_locations_by_batch_numbers.php";
    public static String cancel_purchase_product = "http://khuranasales.co.in/work/cancel_purchase_product.php";
    public static String delete_purchase_product = "http://khuranasales.co.in/work/delete_purchase_product.php";
    public static String get_prebooking_products = "http://khuranasales.co.in/work/get_prebooking_products.php";
    public static String add_prebooking_products = "http://khuranasales.co.in/work/add_new_prebooking_product.php";
    public static String update_prebooking_products = "http://khuranasales.co.in/work/update_prebooking_product.php";
    public static String delete_prebooking_product = "http://khuranasales.co.in/work/delete_prebooking_product.php";
    public static String send_otp_message = "http://khuranasales.co.in/work/send_sms.php";
    public static String send_confirm_booking_sms = "http://khuranasales.co.in/work/send_confirm_booking_sms.php";
    public static String get_prebookings_url = "http://khuranasales.co.in/work/get_prebookings.php";
    public static String cancel_booking = "http://khuranasales.co.in/work/cancel_prebooking.php";
    public static String reconfirm_booking = "http://khuranasales.co.in/work/re_confirm_booking.php";
    public static String send_arrival_sms = "http://khuranasales.co.in/work/send_product_arrival_sms.php";
    public static String get_dashboard_details_url = "http://khuranasales.co.in/inventory/get_dashboard_details.php";

    public static String get_inventory_url = "http://khuranasales.co.in/inventory/get_inventory.php?category=";
    public static String get_inventory_batch_numbers_url = "http://khuranasales.co.in/inventory/get_batch_info_inventory.php?batch_id=";
    public static String get_credit_notes_url = "http://khuranasales.co.in/inventory/get_credit_notes.php";

    public static ArrayList<String> Brands = new ArrayList<String>();

}
