package dao.XML;

import dao.ItemDAO;
import entity.Item;
import xml.ItemWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ItemXMLDAO implements ItemDAO {

    private static final String PATH = "items.xml";

    @Override
    public List<Item> get() {
        try {
            JAXBContext context = JAXBContext.newInstance(ItemWrapper.class, Item.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ItemWrapper itemWrapper = (ItemWrapper) unmarshaller.unmarshal(new File(PATH));
            return itemWrapper.getItems();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Item> items) {
        ItemWrapper itemWrapper = new ItemWrapper(items);
        try {
            JAXBContext context = JAXBContext.newInstance(ItemWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(itemWrapper, new File(PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
