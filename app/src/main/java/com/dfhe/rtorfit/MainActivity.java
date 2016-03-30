package com.dfhe.rtorfit;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dfhe.rtorfit.http.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnGet;
    private FrameLayout flCity;
    private TextView tvCityName;
    private TextView tvCityValue;
    private FrameLayout flDate;
    private TextView tvDate;
    private TextView tvDateValue;
    private FrameLayout flWeek;
    private TextView tvWeek;
    private TextView tvWeekValue;
    private FrameLayout flTemp;
    private TextView tvTemp;
    private TextView tvTempValue;
    private FrameLayout flWeather;
    private TextView tvWeather;
    private TextView tvWeatherValue;
    private EditText etSort;
    private String cityName = "青岛";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        asynGet();
    }

    private void initLayout() {
        btnGet = (Button) findViewById(R.id.id_btnget);
        etSort = (EditText) findViewById(R.id.sort);
        //城市
        flCity = (FrameLayout) findViewById(R.id.fl_city);
        tvCityName = (TextView) flCity.findViewById(R.id.id_tvName);
        tvCityName.setText("城市：");
        tvCityValue = (TextView) flCity.findViewById(R.id.id_tvValue);
        //日期
        flDate = (FrameLayout) findViewById(R.id.fl_date_y);
        tvDate = (TextView) flDate.findViewById(R.id.id_tvName);
        tvDate.setText("日期：");
        tvDateValue = (TextView) flDate.findViewById(R.id.id_tvValue);
        //星期几
        flWeek = (FrameLayout) findViewById(R.id.fl_week);
        tvWeek = (TextView) flWeek.findViewById(R.id.id_tvName);
        tvWeek.setText("星期：");
        tvWeekValue = (TextView) flWeek.findViewById(R.id.id_tvValue);
        //温度
        flTemp = (FrameLayout) findViewById(R.id.fl_temperature);
        tvTemp = (TextView) flTemp.findViewById(R.id.id_tvName);
        tvTemp.setText("温度：");
        tvTempValue = (TextView) flTemp.findViewById(R.id.id_tvValue);
        //今日天气
        flWeather = (FrameLayout) findViewById(R.id.fl_weather);
        tvWeather = (TextView) flWeather.findViewById(R.id.id_tvName);
        tvWeather.setText("天气：");
        tvWeatherValue = (TextView) flWeather.findViewById(R.id.id_tvValue);

        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btnget:
                if(!TextUtils.isEmpty(cityName)){
                    cityName = etSort.getText().toString().trim();
                }
                asynGet();
                break;
        }
    }

    public void asynGet(){
        Call<UserInfo> call = RestClient.getService().getResponse(cityName,"5f8feaa4f5069a6ffa9b067b1bb17f4a");
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                try {
                    UserInfo.ResultEntity.TodayEntity today = response.body().result.today;
                    tvCityValue.setText(today.city);
                    tvDateValue.setText(today.date_y);
                    tvTempValue.setText(today.temperature);
                    tvWeatherValue.setText(today.weather);
                    tvWeekValue.setText(today.week);
                    Toast.makeText(MainActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"城市名称有误",Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
