package com.example.maybe;

public class Tarikh {
    public String currentDate;
    public double totalfToday;
    public double left;
    public double totalCost = 0;

    public double getTotalfToday() {
        return totalfToday;
    }

    public void setTotalfToday(double totalfToday) {
        this.totalfToday = totalfToday;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Tarikh(String currentDate, double totalfToday, double totalCost,  double left){
        this.currentDate = currentDate;
        this.totalfToday = totalfToday;
        this.left = left;
        this.totalCost = totalCost;
    }
    public static class Trans{
        public String description;
        public double cost;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Trans(String description, double cost){
            this.description = description;
            this.cost = cost;
        }
    }
}
