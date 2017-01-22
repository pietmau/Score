
package com.score.mauriziopietrantuono.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditReportInfo {

    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("scoreBand")
    @Expose
    private int scoreBand;
    @SerializedName("clientRef")
    @Expose
    private String clientRef;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("maxScoreValue")
    @Expose
    private int maxScoreValue;
    @SerializedName("minScoreValue")
    @Expose
    private int minScoreValue;
    @SerializedName("monthsSinceLastDefaulted")
    @Expose
    private int monthsSinceLastDefaulted;
    @SerializedName("hasEverDefaulted")
    @Expose
    private boolean hasEverDefaulted;
    @SerializedName("monthsSinceLastDelinquent")
    @Expose
    private int monthsSinceLastDelinquent;
    @SerializedName("hasEverBeenDelinquent")
    @Expose
    private boolean hasEverBeenDelinquent;
    @SerializedName("percentageCreditUsed")
    @Expose
    private int percentageCreditUsed;
    @SerializedName("percentageCreditUsedDirectionFlag")
    @Expose
    private int percentageCreditUsedDirectionFlag;
    @SerializedName("changedScore")
    @Expose
    private int changedScore;
    @SerializedName("currentShortTermDebt")
    @Expose
    private int currentShortTermDebt;
    @SerializedName("currentShortTermNonPromotionalDebt")
    @Expose
    private int currentShortTermNonPromotionalDebt;
    @SerializedName("currentShortTermCreditLimit")
    @Expose
    private int currentShortTermCreditLimit;
    @SerializedName("currentShortTermCreditUtilisation")
    @Expose
    private int currentShortTermCreditUtilisation;
    @SerializedName("changeInShortTermDebt")
    @Expose
    private int changeInShortTermDebt;
    @SerializedName("currentLongTermDebt")
    @Expose
    private int currentLongTermDebt;
    @SerializedName("currentLongTermNonPromotionalDebt")
    @Expose
    private int currentLongTermNonPromotionalDebt;
    @SerializedName("currentLongTermCreditLimit")
    @Expose
    private Object currentLongTermCreditLimit;
    @SerializedName("currentLongTermCreditUtilisation")
    @Expose
    private Object currentLongTermCreditUtilisation;
    @SerializedName("changeInLongTermDebt")
    @Expose
    private int changeInLongTermDebt;
    @SerializedName("numPositiveScoreFactors")
    @Expose
    private int numPositiveScoreFactors;
    @SerializedName("numNegativeScoreFactors")
    @Expose
    private int numNegativeScoreFactors;
    @SerializedName("equifaxScoreBand")
    @Expose
    private int equifaxScoreBand;
    @SerializedName("equifaxScoreBandDescription")
    @Expose
    private String equifaxScoreBandDescription;
    @SerializedName("daysUntilNextReport")
    @Expose
    private int daysUntilNextReport;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScoreBand() {
        return scoreBand;
    }

    public void setScoreBand(int scoreBand) {
        this.scoreBand = scoreBand;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMaxScoreValue() {
        return maxScoreValue;
    }

    public void setMaxScoreValue(int maxScoreValue) {
        this.maxScoreValue = maxScoreValue;
    }

    public int getMinScoreValue() {
        return minScoreValue;
    }

    public void setMinScoreValue(int minScoreValue) {
        this.minScoreValue = minScoreValue;
    }

    public int getMonthsSinceLastDefaulted() {
        return monthsSinceLastDefaulted;
    }

    public void setMonthsSinceLastDefaulted(int monthsSinceLastDefaulted) {
        this.monthsSinceLastDefaulted = monthsSinceLastDefaulted;
    }

    public boolean isHasEverDefaulted() {
        return hasEverDefaulted;
    }

    public void setHasEverDefaulted(boolean hasEverDefaulted) {
        this.hasEverDefaulted = hasEverDefaulted;
    }

    public int getMonthsSinceLastDelinquent() {
        return monthsSinceLastDelinquent;
    }

    public void setMonthsSinceLastDelinquent(int monthsSinceLastDelinquent) {
        this.monthsSinceLastDelinquent = monthsSinceLastDelinquent;
    }

    public boolean isHasEverBeenDelinquent() {
        return hasEverBeenDelinquent;
    }

    public void setHasEverBeenDelinquent(boolean hasEverBeenDelinquent) {
        this.hasEverBeenDelinquent = hasEverBeenDelinquent;
    }

    public int getPercentageCreditUsed() {
        return percentageCreditUsed;
    }

    public void setPercentageCreditUsed(int percentageCreditUsed) {
        this.percentageCreditUsed = percentageCreditUsed;
    }

    public int getPercentageCreditUsedDirectionFlag() {
        return percentageCreditUsedDirectionFlag;
    }

    public void setPercentageCreditUsedDirectionFlag(int percentageCreditUsedDirectionFlag) {
        this.percentageCreditUsedDirectionFlag = percentageCreditUsedDirectionFlag;
    }

    public int getChangedScore() {
        return changedScore;
    }

    public void setChangedScore(int changedScore) {
        this.changedScore = changedScore;
    }

    public int getCurrentShortTermDebt() {
        return currentShortTermDebt;
    }

    public void setCurrentShortTermDebt(int currentShortTermDebt) {
        this.currentShortTermDebt = currentShortTermDebt;
    }

    public int getCurrentShortTermNonPromotionalDebt() {
        return currentShortTermNonPromotionalDebt;
    }

    public void setCurrentShortTermNonPromotionalDebt(int currentShortTermNonPromotionalDebt) {
        this.currentShortTermNonPromotionalDebt = currentShortTermNonPromotionalDebt;
    }

    public int getCurrentShortTermCreditLimit() {
        return currentShortTermCreditLimit;
    }

    public void setCurrentShortTermCreditLimit(int currentShortTermCreditLimit) {
        this.currentShortTermCreditLimit = currentShortTermCreditLimit;
    }

    public int getCurrentShortTermCreditUtilisation() {
        return currentShortTermCreditUtilisation;
    }

    public void setCurrentShortTermCreditUtilisation(int currentShortTermCreditUtilisation) {
        this.currentShortTermCreditUtilisation = currentShortTermCreditUtilisation;
    }

    public int getChangeInShortTermDebt() {
        return changeInShortTermDebt;
    }

    public void setChangeInShortTermDebt(int changeInShortTermDebt) {
        this.changeInShortTermDebt = changeInShortTermDebt;
    }

    public int getCurrentLongTermDebt() {
        return currentLongTermDebt;
    }

    public void setCurrentLongTermDebt(int currentLongTermDebt) {
        this.currentLongTermDebt = currentLongTermDebt;
    }

    public int getCurrentLongTermNonPromotionalDebt() {
        return currentLongTermNonPromotionalDebt;
    }

    public void setCurrentLongTermNonPromotionalDebt(int currentLongTermNonPromotionalDebt) {
        this.currentLongTermNonPromotionalDebt = currentLongTermNonPromotionalDebt;
    }

    public Object getCurrentLongTermCreditLimit() {
        return currentLongTermCreditLimit;
    }

    public void setCurrentLongTermCreditLimit(Object currentLongTermCreditLimit) {
        this.currentLongTermCreditLimit = currentLongTermCreditLimit;
    }

    public Object getCurrentLongTermCreditUtilisation() {
        return currentLongTermCreditUtilisation;
    }

    public void setCurrentLongTermCreditUtilisation(Object currentLongTermCreditUtilisation) {
        this.currentLongTermCreditUtilisation = currentLongTermCreditUtilisation;
    }

    public int getChangeInLongTermDebt() {
        return changeInLongTermDebt;
    }

    public void setChangeInLongTermDebt(int changeInLongTermDebt) {
        this.changeInLongTermDebt = changeInLongTermDebt;
    }

    public int getNumPositiveScoreFactors() {
        return numPositiveScoreFactors;
    }

    public void setNumPositiveScoreFactors(int numPositiveScoreFactors) {
        this.numPositiveScoreFactors = numPositiveScoreFactors;
    }

    public int getNumNegativeScoreFactors() {
        return numNegativeScoreFactors;
    }

    public void setNumNegativeScoreFactors(int numNegativeScoreFactors) {
        this.numNegativeScoreFactors = numNegativeScoreFactors;
    }

    public int getEquifaxScoreBand() {
        return equifaxScoreBand;
    }

    public void setEquifaxScoreBand(int equifaxScoreBand) {
        this.equifaxScoreBand = equifaxScoreBand;
    }

    public String getEquifaxScoreBandDescription() {
        return equifaxScoreBandDescription;
    }

    public void setEquifaxScoreBandDescription(String equifaxScoreBandDescription) {
        this.equifaxScoreBandDescription = equifaxScoreBandDescription;
    }

    public int getDaysUntilNextReport() {
        return daysUntilNextReport;
    }

    public void setDaysUntilNextReport(int daysUntilNextReport) {
        this.daysUntilNextReport = daysUntilNextReport;
    }

}
