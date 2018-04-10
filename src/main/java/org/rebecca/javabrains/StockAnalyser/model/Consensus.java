package org.rebecca.javabrains.StockAnalyser.model;

public class Consensus {

    private String companyName;
    private String ticker;
    private String sector;
    private long numFilers;
    private String largestHolder;
    private double sumMarketValue;

    public Consensus() { }

    public Consensus(String companyName, String ticker, String sector, long numFilers, String largestHolder, double sumMarketValue) {
        this.companyName = companyName;
        this.ticker = ticker;
        this.sector = sector;
        this.numFilers = numFilers;
        this.largestHolder = largestHolder;
        this.sumMarketValue = sumMarketValue;
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

    public String getLargestHolder() {
        return largestHolder;
    }

    public void setLargestHolder(String largestHolder) {
        this.largestHolder = largestHolder;
    }

    public double getSumMarketValue() {
        return sumMarketValue;
    }

    public void setSumMarketValue(double sumMarketValue) {
        this.sumMarketValue = sumMarketValue;
    }
}
