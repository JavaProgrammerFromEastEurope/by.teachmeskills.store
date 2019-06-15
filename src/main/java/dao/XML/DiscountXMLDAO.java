package dao.XML;

import dao.DiscountDAO;
import entity.Discount;
import xml.DiscountWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class DiscountXMLDAO implements DiscountDAO {

    private static final String PATH = "discounts.xml";

    @Override
    public List<Discount> get() {
        try {
            JAXBContext context = JAXBContext.newInstance(DiscountWrapper.class, Discount.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DiscountWrapper discountWrapper = (DiscountWrapper) unmarshaller.unmarshal(new File(PATH));
            return discountWrapper.getDiscounts();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Discount> discounts) {
        DiscountWrapper discountWrapper = new DiscountWrapper(discounts);
        try {
            JAXBContext context = JAXBContext.newInstance(DiscountWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(discountWrapper, new File(PATH));
        } catch (JAXBException e) {
            out.println("Ошибка экспортирования данных!");
            e.printStackTrace();
        }
    }
}