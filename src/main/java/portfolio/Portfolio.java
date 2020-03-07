package portfolio;

import portfolio.investments.Investment;

import java.util.ArrayList;

public class Portfolio<T extends Investment> {
    //TODO Complete this implementation and make it generic

    ArrayList<T> investments = new ArrayList<>();

    public boolean contains(T investment) {
        if (this.getShare(investment.getTitel()) != null) {
            return true;
        }
        return false;
    }

    public void buy(T investment) {
        if (!this.investments.contains(investment)) {
            this.investments.add(investment);
        } else {
            // investments contains investment
            this.getShare(investment.getTitel()).setCount(investment.getCount()+1);
        }
    }

    public void sell(String titel, int count) {
        T investment = this.getShare(titel);
        if (investment != null) {
            if (investment.getCount() <= count) {
                investment.setCount(0);
                investments.remove(investment);
            } else {
                investment.setCount(investment.getCount() - count);
            }
        }
    }

    public T getShare(String titel) {
        for (T t : investments) {
            if (t.getTitel().equals(titel)) {
                return t;
            }
        }
        return null;
    }
}
