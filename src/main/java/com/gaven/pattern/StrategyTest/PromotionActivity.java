package com.gaven.pattern.StrategyTest;

public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }


    public void execut(){
        promotionStrategy.doPromotion();
    }

}
