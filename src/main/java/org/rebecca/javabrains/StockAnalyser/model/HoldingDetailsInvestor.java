package org.rebecca.javabrains.StockAnalyser.model;

public class HoldingDetailsInvestor {
    private String companyID;
    private String companyName;
    private String ticker;
    private String sector;
    private double principalAmount;
    private double marketValue;
    private long quarter;

    @Override
    public String toString() {
        return "HoldingDetailsInvestor{" +
                "companyID='" + companyID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ticker='" + ticker + '\'' +
                ", sector='" + sector + '\'' +
                ", principalAmount=" + principalAmount +
                ", marketValue=" + marketValue +
                ", quarter=" + quarter +
                ", percentChange=" + percentChange +
                ", changeInShares=" + changeInShares +
                ", perPortfolio=" + perPortfolio +
                '}';
    }

    private double percentChange;
    private double changeInShares;
    private double perPortfolio;

    public HoldingDetailsInvestor() { }

    public HoldingDetailsInvestor(String companyID, String companyName, String ticker, String sector, double principalAmount, double marketValue, long quarter, double percentChange, double changeInShares, double perPortfolio) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.ticker = ticker;
        this.sector = sector;
        this.principalAmount = principalAmount;
        this.marketValue = marketValue;
        this.quarter = quarter;
        this.percentChange = percentChange;
        this.changeInShares = changeInShares;
        this.perPortfolio = perPortfolio;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public long getQuarter() {
        return quarter;
    }

    public void setQuarter(long quarter) {
        this.quarter = quarter;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public double getChangeInShares() {
        return changeInShares;
    }

    public void setChangeInShares(double changeInShares) {
        this.changeInShares = changeInShares;
    }

    public double getPerPortfolio() {
        return perPortfolio;
    }

    public void setPerPortfolio(double perPortfolio) {
        this.perPortfolio = perPortfolio;
    }
}
