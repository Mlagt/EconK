package com.company;

public class Calculations {}

class FirstSection{
    //Переменные первого раздела
    double ProceedsPlaned; // Выручка планируемая
    double[] ProceedsDivided = new double[6];
    double IncomePlaned, IncomePlanedCurrentActivities, IncomePlanedInvest, IncomePlanedFinance; //Доход планируемый
    double[] IncomePercentage = new double[6];}

class SecondSection{
    //Переменные второго раздела
    double FixedAssetsPlaned, FixedAssetsThisYear, FixedAssetsNextYear, FixedAssetsInput, FixedAssetsOutput;
    double[] FixedAssetsDivided = new double[6];
    double[] FixedAssetsMonth = new double[11];}

 class ThirdSection{
    //Переменные третьего раздела
    double LaborCosts,  PeoplePlaned, PeopleCurrent, SalaryPlaned, SalaryCurrent, SalaryGrowth;
    double SocialContributions, RateSocialContributions = 34;
    double DepreciationAmount;
    double[] DepreciationNorm = new double[6];
    double[] DepreciationDivided = new double[6];
    double MaterialContributions100Planned, MaterialContributions100Current;
    double[] MaterialContributions100 = new double[3];
    double[] MaterialContributionsDivided = new double[3];
    double MaterialContributionsAmount;
    double OtherCostsPlaned, CostsAmount, CostPrice100;
    double[] CostsAmountDivided = new double[6];
    double[] CostPrice100Divided = new double[6];
}

class ForthSection {
    double ProfitSaleOfGoodsPlaned, ValueAddedTax, RateVAT = 20,
            ProfitCurrentActivities, ProfitIvestActivities,
            ProfitFinanceActivities, ProfitBeforeTaxes,
            ProfitTaxable, ProfitTaxes, ProfitClear;

}

class FifthSection{
    double ReturnOnAssetsRatioCurrent, ReturnOnAssetsRatioPlaned,
            CapitalIntensityRatioCurrent, CapitalIntensityRatioPlaned,
            CapitalToLaborRatioCurrent, CapitalToLaborRatioPlaned,
            ProfitabilityOfFixedAssetsCurrent, ProfitabilityOfFixedAssetsPlaned,
            LaborProductivityCurrent, LaborProductivityPlanned;
}





