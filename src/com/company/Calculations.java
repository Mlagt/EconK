package com.company;

public class Calculations {}

class FirstSection{
    //Переменные первого раздела
    double ProceedsPlanned; // Выручка планируемая
    double[] ProceedsDivided = new double[6];
    double IncomePlanned, IncomePlannedCurrentActivities, IncomePlannedInvest,
            IncomePlannedFinance; //Доход планируемый
    double[] IncomePercentage = new double[6];}

class SecondSection{
    //Переменные второго раздела
    double FixedAssetsPlanned, FixedAssetsThisYear, FixedAssetsNextYear,
            FixedAssetsInput, FixedAssetsOutput;
    double[] FixedAssetsDivided = new double[6];
    double[] FixedAssetsMonth = new double[11];}

 class ThirdSection{
    //Переменные третьего раздела
    double LaborCosts,  PeoplePlanned, PeopleCurrent, SalaryPlanned, SalaryCurrent, SalaryGrowth;
    double SocialContributions, RateSocialContributions = 34;
    double DepreciationAmount;
    double[] DepreciationNorm = new double[6];
    double[] DepreciationDivided = new double[6];
    double MaterialContributions100Planned, MaterialContributions100Current;
    double[] MaterialContributions100 = new double[3];
    double[] MaterialContributionsDivided = new double[3];
    double MaterialContributionsAmount;
    double OtherCostsPlanned, CostsAmount, CostPrice100;
    double[] CostsAmountDivided = new double[6];
    double[] CostPrice100Divided = new double[6];
}

class ForthSection {
    double ProfitSaleOfGoodsPlanned, ValueAddedTax, RateVAT = 20,
            ProfitCurrentActivities, ProfitInvestActivities,
            ProfitFinanceActivities, ProfitBeforeTaxes,
            ProfitTaxable, ProfitTaxes, ProfitClear;

}

class FifthSection{
    double ReturnOnAssetsRatioCurrent, ReturnOnAssetsRatioPlanned,
            CapitalIntensityRatioCurrent, CapitalIntensityRatioPlanned,
            CapitalToLaborRatioCurrent, CapitalToLaborRatioPlanned,
            ProfitabilityOfFixedAssetsCurrent, ProfitabilityOfFixedAssetsPlanned,
            LaborProductivityCurrent, LaborProductivityPlanned,
            PercentLaborProductivityCurrent, PercentLaborProductivityPlanned;
}





