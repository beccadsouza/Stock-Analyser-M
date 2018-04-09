package org.rebecca.javabrains.StockAnalyser.model;

public class Picks {
    private String companyID;
    private String companyName;
    private String ticker;
    private String sector;
    private long numFilers;
    private double marketValue;
    private double principalAmount;
    private double changeInShares;
    private String largestHolder;

    public Picks() { }

    public Picks(String companyID, String companyName, String ticker, String sector, long numFilers, double marketValue, double principalAmount, double changeInShares, String largestHolder) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.ticker = ticker;
        this.sector = sector;
        this.numFilers = numFilers;
        this.marketValue = marketValue;
        this.principalAmount = principalAmount;
        this.changeInShares = changeInShares;
        this.largestHolder = largestHolder;
    }
}
