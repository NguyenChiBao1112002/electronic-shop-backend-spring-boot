package ct250.backend.product;

import java.util.HashMap;
import java.util.Map;

public enum ProductMaterial {
    COTTON,
    CANVAS,
    FABRIC,
    GOLD,
    SILVER,
    COPPER,
    LEATHER,
    SILK,
    DENIM,
    WOOL,
    POLYESTER,
    NYLON,
    LINEN,
    VELVET,
    CHIFFON,
    SPANDEX,
    LACE,
    SYNTHETIC,
    OTHER;

    private static final Map<String, ProductMaterial> stringToEnum = new HashMap<>();

    static {
        for (ProductMaterial productMaterial : values()) {
            stringToEnum.put(productMaterial.name(), productMaterial);
        }
    }

    public static ProductMaterial fromString(String value) {
        return stringToEnum.get(value);
    }
}

