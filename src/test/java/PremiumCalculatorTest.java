//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
//
//public class PremiumCalculatorTest {
//    private PremiumCalculator calculator = new PremiumCalculator();
//    @Test
//    public void calculate() {
//        PolicyObject policyObject1 = new PolicyObject();
//        PolicySubObject policySubObject1 = new PolicySubObject("Fire1", 100.0, RiskType.FIRE);
//        policyObject1.setPolicySubObjects((List.of(policySubObject1)));
//
//        PolicyObject policyObject2 = new PolicyObject();
//        PolicySubObject policySubObject2 = new PolicySubObject("Water1", 8.0, RiskType.WATER);
//        policyObject2.setPolicySubObjects((List.of(policySubObject2)));
//
//        List<PolicyObject> policyObjects = List.of(policyObject1, policyObject2);
//        Policy policy = new Policy("LV19-07-100000-1", PolicyStatus.APPROVED, policyObjects, 0.0);
//
//Assert.assertEquals(2.10, calculator.);
//    }
//
//    @Test
//    public void getFireCoefficient() {
//    }
//
//    @Test
//    public void getWaterCoefficient() {
//    }
//}

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PremiumCalculatorTest {

    private PremiumCalculator calculator = new PremiumCalculator();

    @Test
    public void simpleCalculationCheck() {
        PolicyObject policyObject1 = new PolicyObject();
        PolicySubObject policySubObject1 = new PolicySubObject("Fire1", 100.0, RiskType.FIRE);
        policyObject1.setPolicySubObjects(List.of(policySubObject1));

        PolicyObject policyObject2 = new PolicyObject();
        PolicySubObject policySubObject2 = new PolicySubObject("Water1", 8.0, RiskType.WATER);
        policyObject2.setPolicySubObjects(List.of(policySubObject2));

        List<PolicyObject> policyObjects = List.of(policyObject1, policyObject2);
        Policy policy = new Policy("LV19-07-100000-1", PolicyStatus.APPROVED, policyObjects, 0.0);
        Assert.assertEquals("Mistake 1", "LV19-07-100000-1", policy.getPolicyNumber());

    }

    @Test
    public void multipleObjectCalculationCheck() {
        PolicyObject policyObject1 = new PolicyObject();
        PolicySubObject policyFireSubObject1 = new PolicySubObject("Fire1", 100.0, RiskType.FIRE);
        PolicySubObject policyFireSubObject2 = new PolicySubObject("Fire2", 500.0, RiskType.FIRE);
        PolicySubObject policyFireSubObject3 = new PolicySubObject("Fire3", 150.0, RiskType.FIRE);
        policyObject1.setPolicySubObjects(List.of(policyFireSubObject1, policyFireSubObject2, policyFireSubObject3));

        PolicyObject policyObject2 = new PolicyObject();
        PolicySubObject policyWaterSubObject1 = new PolicySubObject("Water1", 35.0, RiskType.WATER);
        PolicySubObject policyWaterSubObject2 = new PolicySubObject("Water2", 100.0, RiskType.WATER);
        PolicySubObject policyWaterSubObject3 = new PolicySubObject("Water3", 50.0, RiskType.WATER);
        policyObject2.setPolicySubObjects(List.of(policyWaterSubObject1, policyWaterSubObject3, policyWaterSubObject2));
        double premium = policyFireSubObject2.getInsuredSum() * PremiumCalculator.getFireCoefficient(policyFireSubObject2.getInsuredSum())
                + policyWaterSubObject2.getInsuredSum() * PremiumCalculator.getWaterCoefficient(policyWaterSubObject2.getInsuredSum());
        List<PolicyObject> policyObjects = List.of(policyObject1, policyObject2);
        Policy policy = new Policy("LV19-07-100000-2", PolicyStatus.APPROVED, policyObjects, 0.0);


        Assert.assertEquals("Mistake 2 ", 16.5, premium, 0.0001);
        Assert.assertEquals(500, policyFireSubObject2.getInsuredSum(), 0.0001);
    }
}