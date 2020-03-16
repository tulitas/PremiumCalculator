public class PremiumCalculator {




    public static void main(String[] args) {

        calculate(new Policy());
    }


    public static void calculate(Policy policy) {

        PolicyObject policyObject = new PolicyObject();
        policyObject.setObjectName("Flat");

        policy.setPolicyNumber("LV19-07-100000-1");
        policy.setPolicyStatus(PolicyStatus.APPROVED);
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setSubObjectName("TV");
        double sumInsuredFlatFire = policySubObject.setInsuredSum(500);
        double sumInsuredFlatWater = policySubObject.setInsuredSum(100);
        double sumInsuredTvFire = policySubObject.setInsuredSum(100);
        double sumInsuredTvWater = policySubObject.setInsuredSum(8);
        RiskType riskTypeFire = RiskType.FIRE;
        RiskType riskTypeWater = RiskType.WATER;

        System.out.println("Policy Nr.: " + policy.getPolicyNumber());
        System.out.println("Policy object name: " + policyObject.getObjectName() + ", " + " risk type: " + riskTypeFire
                + ", " + riskTypeWater);
        System.out.println("Policy subobject name: " + policySubObject.getSubObjectName() + ", " + " risk type: " + riskTypeFire
                + ", " + riskTypeWater);
        System.out.println("Policy status: " + policy.getPolicyStatus());
        double premiumFlatFire = sumInsuredFlatFire * getFireCoefficient(sumInsuredFlatFire);
        double premiumFlatWater = sumInsuredFlatWater * getWaterCoefficient(sumInsuredFlatWater);
        double premiumFlat = premiumFlatFire + premiumFlatWater;
        System.out.println("Flat premium: " + premiumFlat + " EUR");
        double premiumTvFire = sumInsuredTvFire * getFireCoefficient(sumInsuredTvFire);
        double premiumTvWater = sumInsuredTvWater * getWaterCoefficient(sumInsuredTvWater);
        double premiumTv = premiumTvFire + premiumTvWater;
        System.out.println("TV premium: " + premiumTv + " EUR");


    }

    public static double getFireCoefficient(Double sumInsuredFire) {



        if (sumInsuredFire > 100) {
            return 0.023;
        }

        return 0.013;
    }


    public static double getWaterCoefficient(Double sumInsuredWater) {

        if (sumInsuredWater >= 10) {
            return 0.05;
        }
        return 0.1;
    }

}