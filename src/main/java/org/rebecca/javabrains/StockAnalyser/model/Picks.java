package org.rebecca.javabrains.StockAnalyser.model;

public class Picks {
    private String companyID;
    private String companyName;
    private String ticker;
    private String sector;
    private long numFilers;
    private double sumMarketValue;
    private double sumPrincipalAmount;
    private double sumChangeInShares;
    private String largestHolder;

    public Picks() { }

    public Picks(String companyID, String companyName, String ticker, String sector, long numFilers, double sumMarketValue, double sumPrincipalAmount, double sumChangeInShares, String largestHolder) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.ticker = ticker;
        this.sector = sector;
        this.numFilers = numFilers;
        this.sumMarketValue = sumMarketValue;
        this.sumPrincipalAmount = sumPrincipalAmount;
        this.sumChangeInShares = sumChangeInShares;
        this.largestHolder = largestHolder;
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

    public long getNumFilers() {
        return numFilers;
    }

    public void setNumFilers(long numFilers) {
        this.numFilers = numFilers;
    }

    public double getSumMarketValue() {
        return sumMarketValue;
    }

    public void setSumMarketValue(double sumMarketValue) {
        this.sumMarketValue = sumMarketValue;
    }

    public double getSumPrincipalAmount() {
        return sumPrincipalAmount;
    }

    public void setSumPrincipalAmount(double sumPrincipalAmount) {
        this.sumPrincipalAmount = sumPrincipalAmount;
    }

    public double getSumChangeInShares() {
        return sumChangeInShares;
    }

    public void setSumChangeInShares(double sumChangeInShares) {
        this.sumChangeInShares = sumChangeInShares;
    }

    public String getLargestHolder() {
        return largestHolder;
    }

    public void setLargestHolder(String largestHolder) {
        this.largestHolder = largestHolder;
    }
}
