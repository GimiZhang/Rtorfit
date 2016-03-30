package com.dfhe.rtorfit.http;

/**
 * 项目名称：Rtorfit
 * 类描述：
 * 创建人：zgm
 * 创建时间：2016/3/30 11:24
 * 修改人：Administrator
 * 修改时间：2016/3/30 11:24
 * 修改备注：
 *
 * @param
 */
public class UserInfo {

    public ResultEntity result;
    public static class ResultEntity {
        public SkEntity sk;
        public TodayEntity today;
        public FutureEntity future;

        public static class SkEntity {
            public String temp;
            public String wind_direction;
            public String wind_strength;
            public String humidity;
            public String time;
        }
        public static class TodayEntity {
            public String temperature;
            public String weather;
            public WeatherIdEntity weather_id;
            public String wind;
            public String week;
            public String city;
            public String date_y;
            public String dressing_index;
            public String dressing_advice;
            public String uv_index;
            public String comfort_index;
            public String wash_index;
            public String travel_index;
            public String exercise_index;
            public String drying_index;
            public static class WeatherIdEntity {
                public String fa;
                public String fb;
            }
        }
        public static class FutureEntity {
            public Day20160330Entity day_20160330;
            public Day20160331Entity day_20160331;
            public Day20160401Entity day_20160401;
            public Day20160402Entity day_20160402;
            public Day20160403Entity day_20160403;
            public Day20160404Entity day_20160404;
            public Day20160405Entity day_20160405;

            public static class Day20160330Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160331Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160401Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160402Entity {
                public String temperature;
                public String weather;

                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160403Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;
                
                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160404Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }

            public static class Day20160405Entity {
                public String temperature;
                public String weather;
                public WeatherIdEntity weather_id;
                public String wind;
                public String week;
                public String date;

                public static class WeatherIdEntity {
                    public String fa;
                    public String fb;
                }
            }
        }
    }
}
