package xml;

import entity.Item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Items")
public class ItemWrapper {

    private List<Item> items;

    public ItemWrapper() {}

    public ItemWrapper(List<Item> items) {
        this.items = items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }
}
