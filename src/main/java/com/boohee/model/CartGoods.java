package com.boohee.model;

import com.boohee.utility.BooheeScheme;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class CartGoods extends ModelBase {
    public String       a_photo_url;
    public List<String> all_big_photo_urls;
    public List<String> all_thumb_photo_urls;
    public String       b_photo_url;
    public float        base_price;
    public String       big_photo_url;
    public String       c_photo_url;
    public boolean can_sale = true;
    public int               cart_id;
    public int               category_id;
    public String            category_name;
    public List<FormatModel> chosen_specs;
    public String            created_at;
    public String            description;
    public String            flag_url;
    public Promotion         flash_sale;
    public int               goods_id;
    public Boolean isChecked = Boolean.valueOf(false);
    public float   market_price;
    public int     month_quantity;
    public String  msg;
    public boolean need_carriage;
    public int quantity = 1;
    public Share        share;
    public String       slug;
    public List<String> square_photo_urls;
    public String       state;
    public String       state_text;
    public String       thumb_photo_url;
    public String       title;
    public String       type;
    public String       unit_name;
    public String       user_key;
    public float        weight;

    public enum goods_state {
        initial,
        on_sale,
        not_sale,
        stop_sale
    }

    public enum goods_type {
        Goods,
        PackageGoods,
        SpecGoods
    }

    public static ArrayList<CartGoods> parseCart(JSONObject res) {
        try {
            return (ArrayList) new Gson().fromJson(res.getString("item").toString(), new
                    TypeToken<ArrayList<CartGoods>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CartGoods parseGoodsFromJson(JSONObject object) {
        CartGoods goods = null;
        try {
            return (CartGoods) new Gson().fromJson(object.getJSONObject(BooheeScheme.GOODS).toString(), CartGoods.class);
        } catch (Exception e) {
            e.printStackTrace();
            return goods;
        }
    }
}
