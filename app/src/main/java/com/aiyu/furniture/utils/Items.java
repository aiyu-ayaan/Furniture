package com.aiyu.furniture.utils;

import com.aiyu.furniture.core.database.model.Category;
import com.aiyu.furniture.core.database.model.Furniture;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public static void main(String args) {
        List<Furniture> furnitureItems = new ArrayList<>();

        // Chair Listings (20 items)
        furnitureItems.add(new Furniture("Minceta Velvet Swivel Armchair", "Hybrid between chair and sofa, reclined back, 360 swivel, velvet fabric", null, Category.CHAIR, "https://www.pepperfry.com/product/minceta-leatherette-armchair-in-off-white-and-brown-colour-2189224.html", 9499L, 2));
        furnitureItems.add(new Furniture("Poise Fabric Rocking Chair", "Rocking chair, Acacia wood, multi-colour fabric", null, Category.CHAIR, "https://www.pepperfry.com/product/giuc094-2-2197731.html", 21299L, 4));
        furnitureItems.add(new Furniture("Foster Acacia Wood Chair", "Cafe chair, Acacia wood, honey oak finish, natural cane, leatherette", null, Category.CHAIR, "https://www.pepperfry.com/product/foster-acacia-wood-chair-in-honey-oak-finish-with-natural-cane-and-leatherette-2198475.html", 13999L, 4));
        furnitureItems.add(new Furniture("Cambrose Sheesham Wood Reclining Arm Chair", "Reclining armchair, Sheesham wood, provincial teak finish", null, Category.CHAIR, "https://www.pepperfry.com/product/cambrose-sheesham-wood-reclining-arm-chair-in-provincial-teak-finish-by-ambervill-2132921.html", 16500L, 5));
        furnitureItems.add(new Furniture("Rigel Fabric Arm Chair", "Armchair, grey fabric, ergonomic design, office furniture", null, Category.CHAIR, "https://www.pepperfry.com/product/rigel-fabric-arm-chair-in-grey-and-grey-colour-2232900.html", 10999L, 4));
        furnitureItems.add(new Furniture("Royaloak Vega Wooden Rocking Chair", "Wooden rocking chair, modern design, natural wicker, cushioned seat and backrest", "https://www.royaloakindia.com/media/catalog/product/c/r/cr2701_1_.jpg", Category.CHAIR, "https://www.royaloakindia.com/royaloak-vega-wooden-rocking-chair.html", 12500L, 0));
        furnitureItems.add(new Furniture("Royaloak Boston American Wooden Rocking Chair", "American design, wooden rocking chair, high back support, designed armrest, leatherette cushion", "https://www.royaloakindia.com/media/catalog/product/r/6/r6010-wa024_copy_2.jpg", Category.CHAIR, "https://www.royaloakindia.com/royaloak-boston-american-wooden-rocking-chair.html", 17500L, 0));
        furnitureItems.add(new Furniture("Royaloak Molfino Ottoman - Silver", "Round ottoman, silver colour, polyester jute fabric, solid wood base", "https://www.royaloakindia.com/media/catalog/product/cache/0cba893411104f333a1688317579991e/r/o/royaloak-molfino-ottoman-silver-1.jpg", Category.CHAIR, "https://www.royaloakindia.com/royaloak-molfino-ottoman-silver.html", 2298L, 0));
        furnitureItems.add(new Furniture("Royaloak Vector Ottoman - Silver", "Round ottoman, silver colour, velvet fabric", "https://www.royaloakindia.com/media/catalog/product/cache/0cba89533c5098c7f49a54441b733299/r/o/royaloak-vector-ottoman-silver-1.jpg", Category.CHAIR, "https://www.royaloakindia.com/royaloak-vector-ottoman-silver.html", 2999L, 0));
        furnitureItems.add(new Furniture("Royaloak Rib Ottoman - Rust Color", "Round ottoman, rust colour, velvet fabric", "https://www.royaloakindia.com/media/catalog/product/r/o/royaloak-rib-ottoman-in-rust-colour-1.jpg", Category.CHAIR, "https://www.royaloakindia.com/royaloak-rib-ottoman-rust-colour.html", 2999L, 0));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Grey Colour", "By Kiyan Overseas, 12-Month Warranty Available", null, Category.CHAIR, null, 8499L, 5));
        furnitureItems.add(new Furniture("Asko Leatheratte Arm Chair in Beige Colour", "By Kiyan Overseas, 12-Month Warranty Available", null, Category.CHAIR, null, 7999L, 0));
        furnitureItems.add(new Furniture("Andorra Sheesham Wood Arm Chair In Provincial Teak Finish", "By Woodsworth from Pepperfry, 60-Month Warranty Available", null, Category.CHAIR, null, 9499L, 5));
        furnitureItems.add(new Furniture("Catania Metal Folding Chair in Black Colour With Leatherette Cushion Seat", "By Story@Home, 12-Month Warranty Available", null, Category.CHAIR, null, 1999L, 4));
        furnitureItems.add(new Furniture("Carden Sheesham Wood Arm Chair In Scratch Resistant Provincial Teak Finish And Mocha Mousse Colour With Cushion", "By Woodsworth from Pepperfry, 36-Month Warranty Available", null, Category.CHAIR, null, 9999L, 4));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Brown Colour", "By Kiyan Overseas, 12-Month Warranty Available", null, Category.CHAIR, null, 8499L, 3));
        furnitureItems.add(new Furniture("Stalley Sheesham Wood Arm Chair In Multiprint & Scratch Resistant Honey Oak Finish", "By Amberville from Pepperfry, 36-Month Warranty Available", null, Category.CHAIR, null, 15999L, 5));
        furnitureItems.add(new Furniture("Catania Metal Folding Chair in White & Royal Blue Colour", null, null, Category.CHAIR, null, 1999L, 0));
        furnitureItems.add(new Furniture("Rams Velvet Arm Chair In Grey Colour", null, null, Category.CHAIR, null, 6999L, 0));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Turkish Blue Colour", null, null, Category.CHAIR, null, 6999L, 0));

        // Sofa Listings (20 items)
        furnitureItems.add(new Furniture("Victoria Velvet Sofa Set (3+1+1)", "Velvet sofa set, beige colour, 3+1+1 seating", null, Category.SOFA, "https://www.pepperfry.com/product/victoria-velvet-sofa-set-in-beige-colour-311-2205701.html", 94999L, 4));
        furnitureItems.add(new Furniture("Niki Fabric 3+2+1 Sofa Set", "Fabric sofa set, charcoal grey colour, 3+2+1 seating", null, Category.SOFA, "https://www.pepperfry.com/product/niki-sofa-set-311-in-grey-colour-by-febonic-1863982.html", 44499L, 5));
        furnitureItems.add(new Furniture("Atlanta Velvet 7 Seater Sofa Set", "Velvet 7 seater sofa set, blue & grey colour, 3+2+2 seating", null, Category.SOFA, "https://www.pepperfry.com/product/atlanta-fabric-3-2-2-seater-sofa-set-in-blue-grey-colour-2195283.html", 68499L, 0));
        furnitureItems.add(new Furniture("Elora Fabric Sofa Set (3+2)", "Fabric sofa set, teal green colour, 3+2 seating", null, Category.SOFA, "https://www.pepperfry.com/product/elora-fabric-sofa-set-in-teal-green-colour-with-3-plus-2-combination-1828249.html", 45499L, 4));
        furnitureItems.add(new Furniture("Gozi Fabric 3 Seater Sofa", "Fabric 3 seater sofa, ivory cream colour", null, Category.SOFA, "https://www.pepperfry.com/category/sofa-sets.html", 17499L, 5));
        furnitureItems.add(new Furniture("Royaloak Berlin Fabric Recliner Set (3+2)", "Fabric recliner set, 3-seater power motion, 2-seater manual, high backrest, pillow top armrest", "https://www.royaloakindia.com/media/catalog/product/s/f/sf7018029-3_2.jpg", Category.SOFA, "https://www.royaloakindia.com/royaloak-berlin-fabric-recliner-set-with-three-seater-is-power-motion.html", 89000L, 0));
        furnitureItems.add(new Furniture("Royaloak Miami American Fabric Recliner Three Seater", "American design, fabric recliner, three-seater, dropdown", null, Category.SOFA, "https://www.royaloakindia.com/living/recliners/three-seater-recliners.html", 60000L, 0));
        furnitureItems.add(new Furniture("Royaloak Penang Malaysian Fabric Recliner Three Seater", "Malaysian design, fabric recliner, three-seater", null, Category.SOFA, "https://www.royaloakindia.com/living/recliners/three-seater-recliners.html", 44999L, 0));
        furnitureItems.add(new Furniture("Pedro 3 Seater Sofa In Velvet Camel Beige Colour", "By Trevi Furniture", null, Category.SOFA, null, 28499L, 4));
        furnitureItems.add(new Furniture("Java Fabric 3 Seater Sofa In Imperial Green Colour", "By Trevi Furniture", null, Category.SOFA, null, 24999L, 4));
        furnitureItems.add(new Furniture("Daroo Velvet 3 Seater Sofa in Mocha Brown Colour", "By Febonic", null, Category.SOFA, null, 25999L, 4));
        furnitureItems.add(new Furniture("Bali Velvet 3 Seater Sofa in Blue Colour", "By Trevi Furniture", null, Category.SOFA, null, 20749L, 5));
        furnitureItems.add(new Furniture("Bali Fabric 3 Seater Sofa in Grey Colour", "By Trevi Furniture", null, Category.SOFA, null, 22499L, 4));
        furnitureItems.add(new Furniture("Bali Fabric 3 Seater Sofa In Imperal Green Colour", "By Trevi Furniture", null, Category.SOFA, null, 23499L, 4));
        furnitureItems.add(new Furniture("Niki Fabric 3 Seater Sofa in Royal Blue Colour", "By Febonic", null, Category.SOFA, null, 19999L, 4));
        furnitureItems.add(new Furniture("Bingo Fabric 3 Seater Sofa In Creamy Cashmere Colour", null, null, Category.SOFA, null, 20799L, 0));
        furnitureItems.add(new Furniture("BIngo Fabric 3 Seater Sofa In Grey Colour", null, null, Category.SOFA, null, 20999L, 0));
        furnitureItems.add(new Furniture("Murdock Fabric 3 Seater Sofa in Grey Colour", null, null, Category.SOFA, null, 18999L, 0));
        furnitureItems.add(new Furniture("Jack Velvet 3 Seater Sofa Pink Colour", null, null, Category.SOFA, null, 25599L, 0));
        furnitureItems.add(new Furniture("Fidel Velvet 3 Seater Sofa In Beige Colour", null, null, Category.SOFA, null, 42999L, 0));

        // Lamp Listings (20 items)
        furnitureItems.add(new Furniture("Beige Jute Table Lamp With Wood Base", "Jute shade, wood base", null, Category.LAMP, "https://www.pepperfry.com/product/beige-jute-table-lamp-with-wood-base-2162132.html", 1299L, 4));
        furnitureItems.add(new Furniture("Table Lamp With Fabric Shade", "Fabric shade", null, Category.LAMP, "https://www.pepperfry.com/category/table-lamps.html", 598L, 3));
        furnitureItems.add(new Furniture("Wooden Dome Table Lamp Pink Floral Shade", "Wooden dome, pink floral shade, canvas", null, Category.LAMP, "https://www.pepperfry.com/product/wooden-dome-table-lamp-pink-floral-shade-1957863.html", 709L, 4));
        furnitureItems.add(new Furniture("Klimt Orange Fabric Shade Night Lamp", "Orange fabric shade, metal base, night lamp", null, Category.LAMP, "https://www.pepperfry.com/category/table-lamps.html", 639L, 3));
        furnitureItems.add(new Furniture("Adriana Off White Cotton Shade Night Lamp", "Off white cotton shade, wood base, night lamp", null, Category.LAMP, "https://www.pepperfry.com/category/table-lamps.html", 1410L, 4));
        furnitureItems.add(new Furniture("Royaloak Disperse Diffused Lighting Wooden Floor Lamp", "Wooden floor lamp, brown base, diffused lighting, solid pine wood", null, Category.LAMP, "https://www.royaloakindia.com/royaloak-disperse-diffused-lighting-wooden-floor-lamp-with-brown-base.html", null, 0));
        furnitureItems.add(new Furniture("Symplify Charlotte Brown Wooden Table Lamp", "Wooden table lamp, brown base, white jute lampshade", null, Category.LAMP, "https://www.royaloakindia.com/decor/lighting/table-lamps.html", 3318L, 0));
        furnitureItems.add(new Furniture("Symplify Emanate Wooden Table Lamp", "Wooden table lamp, brown base", null, Category.LAMP, "https://www.royaloakindia.com/decor/lighting/table-lamps.html", 4037L, 0));
        furnitureItems.add(new Furniture("Paola White Jute Shade Table Lamp With Wood Base", "Column lamp, natural wood base, white jute shade", null, Category.LAMP, "https://www.pepperfry.com/product/paola-white-jute-shade-table-lamp-with-wood-base-1960506.html", 1359L, 2));
        furnitureItems.add(new Furniture("Brown Fabric Shade Tripod Table Lamp with Brown Base by Beverly Studio", "Tripod table lamp, brown fabric shade, wood base", null, Category.LAMP, "https://www.pepperfry.com/product/brown-fabric-table-tripod-lamp-by-beverly-studio-1693652.html", 2269L, 4));
        furnitureItems.add(new Furniture("Starlet Brown Natural Fiber Shade Night Lamp With Metal Base", "Night lamp, brown natural fiber shade, metal base", null, Category.LAMP, null, 1079L, 3));
        furnitureItems.add(new Furniture("Retro Farmhouse Table Lamp for Living Room Bedroom Rustic Linen Bedside Nightstand Lamps for Kids Room", "Table lamp, rustic linen shade, wood base", null, Category.LAMP, null, 1378L, 5));
        furnitureItems.add(new Furniture("Mylo Off White Cotton Shade Night Lamp With Steel Base", "Night lamp, off white cotton shade, steel base", null, Category.LAMP, null, 1639L, 2));
        furnitureItems.add(new Furniture("Retro Matt Black Metal Table Lamp, Fabric Shade", null, null, Category.LAMP, null, 499L, 0));
        furnitureItems.add(new Furniture("Off White Satin Shade Table Lamp With Mango Wood Base", null, null, Category.LAMP, null, 1986L, 0));
        furnitureItems.add(new Furniture("Kevin Off White Cotton and Acrylic Shade Night Lamp With Mango wood Base", null, null, Category.LAMP, null, 1399L, 0));
        furnitureItems.add(new Furniture("Exemplary Brown Natural Fiber Shade Night Lamp With Metal Base", null, null, Category.LAMP, null, 909L, 0));
        furnitureItems.add(new Furniture("Mid Century Single Table Lamp with Walnut Finish and Jute Cone Shade", null, null, Category.LAMP, null, 736L, 0));
        furnitureItems.add(new Furniture("Mid Century Single Table Lamp with Walnut Finish and Star Cone Shade", null, null, Category.LAMP, null, 775L, 0));
        furnitureItems.add(new Furniture("Bolanzo Beige Fabric Shade Night Lamp With Brass Base", null, null, Category.LAMP, null, 2529L, 0));

        // Bed Listings (20 items)
        furnitureItems.add(new Furniture("Yuudai Queen Size Bed in Walnut Finish", "Queen size bed, walnut finish, engineered wood, no storage", null, Category.BED, "https://www.pepperfry.com/product/yuudai-queen-size-bed-in-walnut-finish-1936436.html", 9999L, 4));
        furnitureItems.add(new Furniture("Himawari Queen Size Bed with Box & Headboard Storage", "Queen size bed, marble finish, engineered wood, box and headboard storage", null, Category.BED, "https://www.pepperfry.com/product/himwari-queen-size-bed-in-marble-finish-with-box-headboard-storage-2223616.html", 16999L, 5));
        furnitureItems.add(new Furniture("Kosmo Noah Queen Bed In Melamine Finish With Box Storage", "Queen size bed, melamine finish, engineered wood, box storage", null, Category.BED, "https://www.pepperfry.com/product/kosmo-noah-queen-bed-in-sebastian-oak-bamboo-flute-finish-with-box-storage-2195053.html", 14499L, 4));
        furnitureItems.add(new Furniture("Royaloak Taurian King Size Bed with Box Storage", "King size bed, box storage", "https://www.royaloakindia.com/media/catalog/product/b/d/bd20202204-6s_15.jpg", Category.BED, "https://www.royaloakindia.com/royaloak-taurian-king-size-bed-with-box-storage.html", 12900L, 0));
        furnitureItems.add(new Furniture("Royaloak Baleno Queen Bed Without Storage", "Queen bed, without storage", "https://www.royaloakindia.com/media/catalog/product/b/d/bd20202201-5_1.jpg", Category.BED, "https://www.royaloakindia.com/royaloak-baleno-queen-bed-without-storage.html", 11990L, 0));
        furnitureItems.add(new Furniture("Royaloak Willow Upholstered Queen Bed", "Upholstered queen bed", "https://www.royaloakindia.com/media/catalog/product/l/f/lf_copy-800x500.jpg", Category.BED, "https://www.royaloakindia.com/royaloak-willow-upholstered-queen-bed.html", 10990L, 0));
        furnitureItems.add(new Furniture("Jacklin Fabric King Size Bed in Cream Colour", "King size bed, cream-colored fabric upholstery", null, Category.BED, "https://www.pepperfry.com/product/jacklin-fabric-king-size-bed-in-cream-colour-2062945.html", 44330L, 4));
        furnitureItems.add(new Furniture("Arthur Queen Size Bed in Walnut Finish", "Queen size bed, walnut finish", null, Category.BED, "https://www.pepperfry.com/product/arthur-queen-size-bed-in-walnut-finish-1965036.html", 10315L, 4));
        furnitureItems.add(new Furniture("Persia King Size Bed in Wenge Finish", "King size bed, wenge finish", null, Category.BED, null, 11999L, 4));
        furnitureItems.add(new Furniture("Yokohama King size Bed in Planked Walnut Finish with Hydraulic Storage & Upholstered Headboard Storage", "King size bed, planked walnut finish, hydraulic storage & upholstered headboard storage", null, Category.BED, null, 23499L, 4));
        furnitureItems.add(new Furniture("Kosmo Jude King Size Bed in Sheesham Finish with Box Storage", "King size bed, sheesham finish, box storage", null, Category.BED, null, 37499L, 4));
        furnitureItems.add(new Furniture("Ryouta Upholstered King Size Bed in Wenge Finish with Drawer Storage", "Upholstered king size bed, wenge finish, drawer storage", null, Category.BED, null, 21499L, 4));
        furnitureItems.add(new Furniture("Seto King Size Bed In Planked Walnut Finish", "King size bed, planked walnut finish", null, Category.BED, null, 14999L, 4));
        furnitureItems.add(new Furniture("Kosmo Noah Queen Bed In Melamine Finish With Box Storage", "Queen size bed, melamine finish, box storage", null, Category.BED, null, 14499L, 0));
        furnitureItems.add(new Furniture("Eva Sheesham Wood Queen Size Bed In Honey Oak Finish", "Queen size bed, sheesham wood, honey oak finish", null, Category.BED, null, 23999L, 0));
        furnitureItems.add(new Furniture("Seto Single Bed in Planked Walnut Finish with Box Storage", "Single bed, planked walnut finish, box storage", null, Category.BED, null, 8399L, 0));
        furnitureItems.add(new Furniture("Kosmo Solace Queen Bed In Sheesham Finish With Box Storage", "Queen size bed, sheesham finish, box storage", null, Category.BED, null, 14799L, 0));
        furnitureItems.add(new Furniture("Pluto Sheesham Wood Queen Size Bed in Dark Brown Colour with Box Storage", "Queen size bed, sheesham wood, dark brown colour, box storage", null, Category.BED, null, 30249L, 0));
        furnitureItems.add(new Furniture("Tivoli King Size Bed In Black Walnut Colour with Hydraulic Storage & Upholstered Head Rest", "King size bed, black walnut colour, hydraulic storage & upholstered head rest", null, Category.BED, null, 42000L, 0));
        furnitureItems.add(new Furniture("Willow Upholstered King Size Bed In Grey Colour", "Upholstered king size bed, grey colour", null, Category.BED, null, 14000L, 0));

        // Print the list (optional)

    }
}