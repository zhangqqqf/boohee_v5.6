package com.boohee.food;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.api.FoodApi;
import com.boohee.model.CustomFood;
import com.boohee.one.R;
import com.boohee.one.http.JsonCallback;
import com.boohee.one.ui.adapter.SimpleBaseAdapter;
import com.boohee.one.ui.adapter.SimpleBaseAdapter.ViewHolder;
import com.boohee.utility.ImageLoaderOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import org.json.JSONObject;

public class CustomFoodListAdapter extends SimpleBaseAdapter<CustomFood> {

    private class DelListener implements OnClickListener {
        private int position;

        public DelListener(int position) {
            this.position = position;
        }

        public void onClick(View v) {
            new Builder(CustomFoodListAdapter.this.context).setMessage("确定要删除吗？")
                    .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (CustomFoodListAdapter.this.data != null) {
                        FoodApi.deleteCustomFood(((CustomFood) CustomFoodListAdapter.this.data
                                .get(DelListener.this.position)).id, CustomFoodListAdapter.this
                                .context, new JsonCallback((Activity) CustomFoodListAdapter.this
                                .context) {
                            public void onFinish() {
                                super.onFinish();
                            }

                            public void ok(JSONObject object) {
                                super.ok(object);
                                CustomFoodListAdapter.this.remove(DelListener.this.position);
                                CustomFoodListAdapter.this.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }).setNegativeButton("取消", null).show();
        }
    }

    public CustomFoodListAdapter(Context context, List<CustomFood> data) {
        super(context, data);
    }

    public int getItemResource() {
        return R.layout.hf;
    }

    public View getItemView(int position, View convertView, ViewHolder holder) {
        CustomFood food = (CustomFood) getItem(position);
        if (food != null) {
            ImageView civ_title = (ImageView) holder.getView(R.id.civ_icon);
            TextView tv_calory = (TextView) holder.getView(R.id.tv_calory);
            TextView tv_unit = (TextView) holder.getView(R.id.tv_unit);
            ImageView iv_health_light = (ImageView) holder.getView(R.id.iv_light);
            ((TextView) holder.getView(R.id.tv_name)).setText(food.food_name);
            ImageLoader.getInstance().displayImage(food.image_url, civ_title, ImageLoaderOptions
                    .global((int) R.drawable.aa2));
            if (TextUtils.isEmpty(food.calory) || TextUtils.isEmpty(food.calory)) {
                tv_calory.setText("0");
            } else {
                tv_calory.setText(Math.round(Float.parseFloat(food.calory)) + "");
            }
            tv_unit.setText(String.format(" 千卡/%1$s%2$s", new Object[]{food.amount, food
                    .unit_name}));
            iv_health_light.setBackgroundResource(R.drawable.a9a);
            iv_health_light.setOnClickListener(new DelListener(position));
        }
        return convertView;
    }
}
