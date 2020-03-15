public class PremiumCalculator {


    public static void main(String[] args) {
        calculate();
    }


    private static void calculate() {

        PolicyObject policyObject = new PolicyObject();
        policyObject.setObjectName("Flat");
        Policy policy = new Policy();
        policy.setPolicyNumber("LV19-07-100000-1");
        policy.setPolicyStatus(PolicyStatus.APPROVED);
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setSubObjectName("TV");
        RiskType riskTypeFire = RiskType.FIRE;
        RiskType riskTypeWater = RiskType.WATER;

        System.out.println("Policy Nr.: " + policy.getPolicyNumber());
        System.out.println("Policy object name: " + policyObject.getObjectName() + ", " + " risk type: " + riskTypeFire
                + ", " + riskTypeWater);
        System.out.println("Policy subobject name: " + policySubObject.getSubObjectName() + ", " + " risk type: " + riskTypeFire
                + ", " + riskTypeWater);
        System.out.println("Policy status: " + policy.getPolicyStatus());

    }

    double getFireCoefficient(Double sumInsuredFire) {
        if (sumInsuredFire > 100) {
            return 0.023;
        }
        return 0.013;

    }

    double getWaterCoefficient(Double sumInsuredFire) {
        if (sumInsuredFire >= 10) {
            return 0.05;
        }
        return 0.1;
    }

}