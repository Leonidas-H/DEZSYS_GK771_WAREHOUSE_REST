package rest.warehouse;

import rest.model.ProductData;
import rest.model.ProductTemplate;
import rest.model.WarehouseData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class WarehouseSimulation {
    private final Random rand = new Random();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private int getRandomInt(int inMinimum, int inMaximum) {

        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        Long rounded = Math.round(number);
        return rounded.intValue();

    }

    private final ProductTemplate[] templates = {
            new ProductTemplate("Vöslauer", "Wasser", new String[]{"0.5L", "1L", "3L"}, 500, 5000),
            new ProductTemplate("Römerquelle", "Wasser", new String[]{"0.5L", "1L", "3L"}, 500, 4000),
            new ProductTemplate("Apfelsaft", "Saft", new String[]{"0.25L", "0.5L", "1L"}, 300, 2000),
            new ProductTemplate("Orangensaft", "Saft", new String[]{"0.25L", "0.5L", "1L"}, 300, 2500),
            new ProductTemplate("Reis", "Nahrungsmittel", new String[]{"700g", "1kg", "3kg"}, 50, 500),
            new ProductTemplate("Pasta", "Nahrungsmittel", new String[]{"700g", "1kg", "3kg"}, 50, 500),
            new ProductTemplate("Milch", "Milch", new String[]{"0.5L", "1L", "2L"}, 200, 3000)
    };

    public WarehouseData getData(String warehouseID, String warehouseName) {
        WarehouseData warehouse = new WarehouseData();
        warehouse.setWarehouseID(warehouseID);
        warehouse.setWarehouseName(warehouseName);
        warehouse.setTimestamp(LocalDateTime.now().format(formatter));

        ArrayList<ProductData> productList = new ArrayList<>();
        int productCount = getRandomInt(3, templates.length);

        for (int i = 0; i < productCount; i++) {
            ProductTemplate template = templates[rand.nextInt(templates.length)];
            String unit = template.getUnits()[rand.nextInt(template.getUnits().length)];
            int quantity = getRandomInt(template.getMinQty(), template.getMaxQty());
            String id = String.format("P-%03d", i + 1);
            productList.add(new ProductData(id, template.getName(), template.getCategory(), quantity, unit));
        }

        warehouse.setProductDataList(productList);
        return warehouse;
    }
}



