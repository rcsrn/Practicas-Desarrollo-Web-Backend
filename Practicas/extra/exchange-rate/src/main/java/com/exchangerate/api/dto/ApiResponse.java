package com.exchangerate.api.dto;

public class ApiResponse{
    public Data data;
    public long timestamp;

    public class Data{
        public String id;
        public String symbol;
        public String currencySymbol;
        public String type;
        public String rateUsd;
    }

    @Override public String toString() {
        return "{ \"rate\":" + data.rateUsd + " }";
    }
}
