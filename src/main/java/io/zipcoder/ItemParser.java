package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    Pattern pattern;
    Matcher matcher;
    public List<Item> parseItemList(String valueToParse) {
        List<Item> itemList = new ArrayList<>();
    String[] array = valueToParse.split("##");
        for (String item: array){
        try {
            itemList.add(parseSingleItem(item));
        } catch (ItemParseException e) {
            e.printStackTrace();
        }
    }
        return itemList;
}

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        List<String> itemBuider = new ArrayList<>();
        String [] separatedObjects = singleItem.toLowerCase().split(";");
        try {
            for (String value : separatedObjects) {
                itemBuider.add(value.split("[:@^*%#]")[1]);
            }
        }catch(ArrayIndexOutOfBoundsException aobe){
            throw new ItemParseException();
        }
        Item item = new Item(itemBuider.get(0),Double.valueOf(itemBuider.get(1)),itemBuider.get(2),itemBuider.get(3));
        return item;
    }

//    public Item parseSingleItem(){
//        return null;
//    }
//
//    public List<Item> parseItemList(String valueToParse){
//        return null;
//    }




}
