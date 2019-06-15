package xml;

import entity.Discount;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Discounts")
public class DiscountWrapper {

    public DiscountWrapper() {}

    private List<Discount> discounts;

    public DiscountWrapper(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    @XmlElement(name = "discount")
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
