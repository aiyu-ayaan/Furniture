package com.aiyu.furniture.utils;

import android.text.TextUtils;
import android.util.Log;

import com.aiyu.furniture.core.database.model.Category;
import com.aiyu.furniture.core.database.model.Furniture;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.inject.Inject;

public class Items {
    private static final String TAG = "Items";
    private static final String NO_IMAGE_FOUND = "https://www.amazon.in/Saamenia-FurnitureTM-Sheesham-Furniture-Without/dp/B09LYHQBS5";


    @Inject
    FirebaseFirestore db;

    @Inject
    public Items() {

    }

    public static List<Furniture> imageList() {
        List<Furniture> furnitureItems = new ArrayList<>();

        // Chair Listings (20 items)
        furnitureItems.add(new Furniture("Minceta Velvet Swivel Armchair", "Hybrid between chair and sofa, reclined back, 360 swivel, velvet fabric", "", Category.CHAIR, "", 9499L, 2));
        furnitureItems.add(new Furniture("Poise Fabric Rocking Chair", "Rocking chair, Acacia wood, multi-colour fabric", "", Category.CHAIR, "", 21299L, 4));
        furnitureItems.add(new Furniture("Foster Acacia Wood Chair", "Cafe chair, Acacia wood, honey oak finish, natural cane, leatherette", "", Category.CHAIR, "", 13999L, 4));
        furnitureItems.add(new Furniture("Cambrose Sheesham Wood Reclining Arm Chair", "Reclining armchair, Sheesham wood, provincial teak finish", "", Category.CHAIR, "", 16500L, 5));
        furnitureItems.add(new Furniture("Rigel Fabric Arm Chair", "Armchair, grey fabric, ergonomic design, office furniture", "", Category.CHAIR, "", 10999L, 4));
        furnitureItems.add(new Furniture("Royaloak Vega Wooden Rocking Chair", "Wooden rocking chair, modern design, natural wicker, cushioned seat and backrest", "", Category.CHAIR, "", 12500L, 0));
        furnitureItems.add(new Furniture("Royaloak Boston American Wooden Rocking Chair", "American design, wooden rocking chair, high back support, designed armrest, leatherette cushion", "", Category.CHAIR, "", 17500L, 0));
        furnitureItems.add(new Furniture("Royaloak Molfino Ottoman - Silver", "Round ottoman, silver colour, polyester jute fabric, solid wood base", "", Category.CHAIR, "", 2298L, 0));
        furnitureItems.add(new Furniture("Royaloak Vector Ottoman - Silver", "Round ottoman, silver colour, velvet fabric", "", Category.CHAIR, "", 2999L, 0));
        furnitureItems.add(new Furniture("Royaloak Rib Ottoman - Rust Color", "Round ottoman, rust colour, velvet fabric", "", Category.CHAIR, "", 2999L, 0));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Grey Colour", "By Kiyan Overseas, 12-Month Warranty Available", "", Category.CHAIR, "", 8499L, 5));
        furnitureItems.add(new Furniture("Asko Leatheratte Arm Chair in Beige Colour", "By Kiyan Overseas, 12-Month Warranty Available", "", Category.CHAIR, "", 7999L, 0));
        furnitureItems.add(new Furniture("Andorra Sheesham Wood Arm Chair In Provincial Teak Finish", "By Woodsworth from Pepperfry, 60-Month Warranty Available", "", Category.CHAIR, "", 9499L, 5));
        furnitureItems.add(new Furniture("Catania Metal Folding Chair in Black Colour With Leatherette Cushion Seat", "By Story@Home, 12-Month Warranty Available", "", Category.CHAIR, "", 1999L, 4));
        furnitureItems.add(new Furniture("Carden Sheesham Wood Arm Chair In Scratch Resistant Provincial Teak Finish And Mocha Mousse Colour With Cushion", "By Woodsworth from Pepperfry, 36-Month Warranty Available", "", Category.CHAIR, "", 9999L, 4));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Brown Colour", "By Kiyan Overseas, 12-Month Warranty Available", "", Category.CHAIR, "", 8499L, 3));
        furnitureItems.add(new Furniture("Stalley Sheesham Wood Arm Chair In Multiprint & Scratch Resistant Honey Oak Finish", "By Amberville from Pepperfry, 36-Month Warranty Available", "", Category.CHAIR, "", 15999L, 5));
        furnitureItems.add(new Furniture("Catania Metal Folding Chair in White & Royal Blue Colour", null, "", Category.CHAIR, "", 1999L, 0));
        furnitureItems.add(new Furniture("Rams Velvet Arm Chair In Grey Colour", null, "", Category.CHAIR, "", 6999L, 0));
        furnitureItems.add(new Furniture("Magan Leatheratte Arm Chair in Turkish Blue Colour", null, "", Category.CHAIR, "", 6999L, 0));

        // Sofa Listings (20 items)
        furnitureItems.add(new Furniture("Victoria Velvet Sofa Set (3+1+1)", "Velvet sofa set, beige colour, 3+1+1 seating", "", Category.SOFA, "", 94999L, 4));
        furnitureItems.add(new Furniture("Niki Fabric 3+2+1 Sofa Set", "Fabric sofa set, charcoal grey colour, 3+2+1 seating", "", Category.SOFA, "", 44499L, 5));
        furnitureItems.add(new Furniture("Atlanta Velvet 7 Seater Sofa Set", "Velvet 7 seater sofa set, blue & grey colour, 3+2+2 seating", "", Category.SOFA, "", 68499L, 0));
        furnitureItems.add(new Furniture("Elora Fabric Sofa Set (3+2)", "Fabric sofa set, teal green colour, 3+2 seating", "", Category.SOFA, "", 45499L, 4));
        furnitureItems.add(new Furniture("Gozi Fabric 3 Seater Sofa", "Fabric 3 seater sofa, ivory cream colour", "", Category.SOFA, "", 17499L, 5));
        furnitureItems.add(new Furniture("Royaloak Berlin Fabric Recliner Set (3+2)", "Fabric recliner set, 3-seater power motion, 2-seater manual, high backrest, pillow top armrest", "", Category.SOFA, "", 89000L, 0));
        furnitureItems.add(new Furniture("Royaloak Miami American Fabric Recliner Three Seater", "American design, fabric recliner, three-seater, dropdown", "", Category.SOFA, "", 60000L, 0));
        furnitureItems.add(new Furniture("Royaloak Penang Malaysian Fabric Recliner Three Seater", "Malaysian design, fabric recliner, three-seater", "", Category.SOFA, "", 44999L, 0));
        furnitureItems.add(new Furniture("Pedro 3 Seater Sofa In Velvet Camel Beige Colour", "By Trevi Furniture", "", Category.SOFA, "", 28499L, 4));
        furnitureItems.add(new Furniture("Java Fabric 3 Seater Sofa In Imperial Green Colour", "By Trevi Furniture", "", Category.SOFA, "", 24999L, 4));
        furnitureItems.add(new Furniture("Daroo Velvet 3 Seater Sofa in Mocha Brown Colour", "By Febonic", "", Category.SOFA, "", 25999L, 4));
        furnitureItems.add(new Furniture("Bali Velvet 3 Seater Sofa in Blue Colour", "By Trevi Furniture", "", Category.SOFA, "", 20749L, 5));
        furnitureItems.add(new Furniture("Bali Fabric 3 Seater Sofa in Grey Colour", "By Trevi Furniture", "", Category.SOFA, "", 22499L, 4));
        furnitureItems.add(new Furniture("Bali Fabric 3 Seater Sofa In Imperal Green Colour", "By Trevi Furniture", "", Category.SOFA, "", 23499L, 4));
        furnitureItems.add(new Furniture("Niki Fabric 3 Seater Sofa in Royal Blue Colour", "By Febonic", "", Category.SOFA, "", 19999L, 4));
        furnitureItems.add(new Furniture("Bingo Fabric 3 Seater Sofa In Creamy Cashmere Colour", null, "", Category.SOFA, "", 20799L, 0));
        furnitureItems.add(new Furniture("BIngo Fabric 3 Seater Sofa In Grey Colour", null, "", Category.SOFA, "", 20999L, 0));
        furnitureItems.add(new Furniture("Murdock Fabric 3 Seater Sofa in Grey Colour", null, "", Category.SOFA, "", 18999L, 0));
        furnitureItems.add(new Furniture("Jack Velvet 3 Seater Sofa Pink Colour", null, "", Category.SOFA, "", 25599L, 0));
        furnitureItems.add(new Furniture("Fidel Velvet 3 Seater Sofa In Beige Colour", null, "", Category.SOFA, "", 42999L, 0));

        // Lamp Listings (20 items)
        furnitureItems.add(new Furniture("Beige Jute Table Lamp With Wood Base", "Jute shade, wood base", "", Category.LAMP, "", 1299L, 4));
        furnitureItems.add(new Furniture("Table Lamp With Fabric Shade", "Fabric shade", "", Category.LAMP, "", 598L, 3));
        furnitureItems.add(new Furniture("Wooden Dome Table Lamp Pink Floral Shade", "Wooden dome, pink floral shade, canvas", "", Category.LAMP, "", 709L, 4));
        furnitureItems.add(new Furniture("Klimt Orange Fabric Shade Night Lamp", "Orange fabric shade, metal base, night lamp", "", Category.LAMP, "", 639L, 3));
        furnitureItems.add(new Furniture("Adriana Off White Cotton Shade Night Lamp", "Off white cotton shade, wood base, night lamp", "", Category.LAMP, "", 1410L, 4));
        furnitureItems.add(new Furniture("Royaloak Disperse Diffused Lighting Wooden Floor Lamp", "Wooden floor lamp, brown base, diffused lighting, solid pine wood", "", Category.LAMP, "", null, 0));
        furnitureItems.add(new Furniture("Symplify Charlotte Brown Wooden Table Lamp", "Wooden table lamp, brown base, white jute lampshade", "", Category.LAMP, "", 3318L, 0));
        furnitureItems.add(new Furniture("Symplify Emanate Wooden Table Lamp", "Wooden table lamp, brown base", "", Category.LAMP, "", 4037L, 0));
        furnitureItems.add(new Furniture("Paola White Jute Shade Table Lamp With Wood Base", "Column lamp, natural wood base, white jute shade", "", Category.LAMP, "", 1359L, 2));
        furnitureItems.add(new Furniture("Brown Fabric Shade Tripod Table Lamp with Brown Base by Beverly Studio", "Tripod table lamp, brown fabric shade, wood base", "", Category.LAMP, "", 2269L, 4));
        furnitureItems.add(new Furniture("Starlet Brown Natural Fiber Shade Night Lamp With Metal Base", "Night lamp, brown natural fiber shade, metal base", "", Category.LAMP, "", 1079L, 3));
        furnitureItems.add(new Furniture("Retro Farmhouse Table Lamp for Living Room Bedroom Rustic Linen Bedside Nightstand Lamps for Kids Room", "Table lamp, rustic linen shade, wood base", "", Category.LAMP, "", 1378L, 5));
        furnitureItems.add(new Furniture("Mylo Off White Cotton Shade Night Lamp With Steel Base", "Night lamp, off white cotton shade, steel base", "", Category.LAMP, "", 1639L, 2));
        furnitureItems.add(new Furniture("Retro Matt Black Metal Table Lamp, Fabric Shade", null, "", Category.LAMP, "", 499L, 0));
        furnitureItems.add(new Furniture("Off White Satin Shade Table Lamp With Mango Wood Base", null, "", Category.LAMP, "", 1986L, 0));
        furnitureItems.add(new Furniture("Kevin Off White Cotton and Acrylic Shade Night Lamp With Mango wood Base", null, "", Category.LAMP, "", 1399L, 0));
        furnitureItems.add(new Furniture("Exemplary Brown Natural Fiber Shade Night Lamp With Metal Base", null, "", Category.LAMP, "", 909L, 0));
        furnitureItems.add(new Furniture("Mid Century Single Table Lamp with Walnut Finish and Jute Cone Shade", null, "", Category.LAMP, "", 736L, 0));
        furnitureItems.add(new Furniture("Mid Century Single Table Lamp with Walnut Finish and Star Cone Shade", null, "", Category.LAMP, "", 775L, 0));
        furnitureItems.add(new Furniture("Bolanzo Beige Fabric Shade Night Lamp With Brass Base", null, "", Category.LAMP, "", 2529L, 0));

        // Bed Listings (20 items)
        furnitureItems.add(new Furniture("Yuudai Queen Size Bed in Walnut Finish", "Queen size bed, walnut finish, engineered wood, no storage", "", Category.BED, "", 9999L, 4));
        furnitureItems.add(new Furniture("Himawari Queen Size Bed with Box & Headboard Storage", "Queen size bed, marble finish, engineered wood, box and headboard storage", "", Category.BED, "", 16999L, 5));
        furnitureItems.add(new Furniture("Kosmo Noah Queen Bed In Melamine Finish With Box Storage", "Queen size bed, melamine finish, engineered wood, box storage", "", Category.BED, "", 14499L, 4));
        furnitureItems.add(new Furniture("Royaloak Taurian King Size Bed with Box Storage", "King size bed, box storage", "", Category.BED, "", 12900L, 0));
        furnitureItems.add(new Furniture("Royaloak Baleno Queen Bed Without Storage", "Queen bed, without storage", "", Category.BED, "", 11990L, 0));
        furnitureItems.add(new Furniture("Royaloak Willow Upholstered Queen Bed", "Upholstered queen bed", "", Category.BED, "", 10990L, 0));
        furnitureItems.add(new Furniture("Jacklin Fabric King Size Bed in Cream Colour", "King size bed, cream-colored fabric upholstery", "", Category.BED, "", 44330L, 4));
        furnitureItems.add(new Furniture("Arthur Queen Size Bed in Walnut Finish", "Queen size bed, walnut finish", "", Category.BED, "", 10315L, 4));
        furnitureItems.add(new Furniture("Persia King Size Bed in Wenge Finish", "King size bed, wenge finish", "", Category.BED, "", 11999L, 4));
        furnitureItems.add(new Furniture("Yokohama King size Bed in Planked Walnut Finish with Hydraulic Storage & Upholstered Headboard Storage", "King size bed, planked walnut finish, hydraulic storage & upholstered headboard storage", "", Category.BED, "", 23499L, 4));
        furnitureItems.add(new Furniture("Kosmo Jude King Size Bed in Sheesham Finish with Box Storage", "King size bed, sheesham finish, box storage", "", Category.BED, "", 37499L, 4));
        furnitureItems.add(new Furniture("Ryouta Upholstered King Size Bed in Wenge Finish with Drawer Storage", "Upholstered king size bed, wenge finish, drawer storage", "", Category.BED, "", 21499L, 4));
        furnitureItems.add(new Furniture("Seto King Size Bed In Planked Walnut Finish", "King size bed, planked walnut finish", "", Category.BED, "", 14999L, 4));
        furnitureItems.add(new Furniture("Kosmo Noah Queen Bed In Melamine Finish With Box Storage", "Queen size bed, melamine finish, box storage", "", Category.BED, "", 14499L, 0));
        furnitureItems.add(new Furniture("Eva Sheesham Wood Queen Size Bed In Honey Oak Finish", "Queen size bed, sheesham wood, honey oak finish", "", Category.BED, "", 23999L, 0));
        furnitureItems.add(new Furniture("Seto Single Bed in Planked Walnut Finish with Box Storage", "Single bed, planked walnut finish, box storage", "", Category.BED, "", 8399L, 0));
        furnitureItems.add(new Furniture("Kosmo Solace Queen Bed In Sheesham Finish With Box Storage", "Queen size bed, sheesham finish, box storage", "", Category.BED, "", 14799L, 0));
        furnitureItems.add(new Furniture("Pluto Sheesham Wood Queen Size Bed in Dark Brown Colour with Box Storage", "Queen size bed, sheesham wood, dark brown colour, box storage", "", Category.BED, "", 30249L, 0));
        furnitureItems.add(new Furniture("Tivoli King Size Bed In Black Walnut Colour with Hydraulic Storage & Upholstered Head Rest", "King size bed, black walnut colour, hydraulic storage & upholstered head rest", "", Category.BED, "", 42000L, 0));
        furnitureItems.add(new Furniture("Willow Upholstered King Size Bed In Grey Colour", "Upholstered king size bed, grey colour", "", Category.BED, "", 14000L, 0));

        return furnitureItems;

    }

    private String fetchImageUrl(String query, Category category) {
        String apiKey = "";
        String urlString = "https://api.pexels.com/v1/search?query=" + query + "&per_page=80";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set authorization header
            conn.setRequestProperty("Authorization", apiKey);
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                Log.e(TAG, "fetchImageUrl: " + responseCode);
                return NO_IMAGE_FOUND;
            }

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            reader.close();

            JSONObject responseObject = new JSONObject(jsonResponse.toString());
            JSONArray photos = responseObject.getJSONArray("photos");

            // Additional response metadata
            int totalResults = responseObject.getInt("total_results");
            int page = responseObject.getInt("page");
            int perPage = responseObject.getInt("per_page");
            String nextPage = responseObject.optString("next_page", "");

            Log.d(TAG, "Total Results: " + totalResults + ", Page: " + page + ", Per Page: " + perPage + ", Next Page: " + nextPage);

            if (photos.length() > 0) {
                // First, try to find an image matching the query
                for (int i = 0; i < photos.length(); i++) {
                    JSONObject photo = photos.getJSONObject(i);
                    String alt = photo.optString("alt", "").toLowerCase();

                    if (alt.contains(query.toLowerCase()) || alt.contains(category.name())) {
                        Log.i(TAG, "fetchImageUrl: Found food-related image");
                        return getPreferredImageUrl(photo);
                    }
                }

                // If no specific match, return a random image
                Log.i(TAG, "fetchImageUrl: Returning random image");
                Random random = new Random();
                return getPreferredImageUrl(photos.getJSONObject(random.nextInt(photos.length())));
            }

        } catch (IOException | JSONException e) {
            Log.e(TAG, "fetchImageUrl: " + e.getMessage());
        }

        return NO_IMAGE_FOUND;
    }

    // Helper method to get preferred image URL
    private String getPreferredImageUrl(JSONObject photo) throws JSONException {
        JSONObject srcUrls = photo.getJSONObject("src");

        // Prefer large2x, fallback to other sizes
        String[] preferredSizes = {"large2x", "large", "medium", "original"};

        for (String size : preferredSizes) {
            String url = srcUrls.optString(size);
            if (!TextUtils.isEmpty(url)) {
                return url;
            }
        }

        return NO_IMAGE_FOUND;
    }


    private String fetchImageUrlUnsplash(String query, Category category) {
        String apiKey = "";
        String urlString = "https://api.unsplash.com/search/photos?page=1&query=" + query + "&client_id=" + apiKey;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                Log.e(TAG, "fetchImageUrl: " + responseCode);
                return "https://www.istockphoto.com/photos/no-food-or-drink-sign"; // Fallback image
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject jsonObject = new JSONObject(jsonResponse.toString());
            JSONArray results = jsonObject.getJSONArray("results");

            if (results.length() > 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject result = results.getJSONObject(i);
                    String description = result.optString("description", "").toLowerCase();
//                if description contains food name
                    if (description.contains(query.toLowerCase()) || description.contains(category.name())) {
                        Log.i(TAG, "fetchImageUrl: Find the name on description");
                        return result.getJSONObject("urls").getString("regular");
                    }
                }
//                else return random image
                Log.i(TAG, "fetchImageUrl: else");
                Random random = new Random(results.length());
                return results.getJSONObject(random.nextInt(results.length())).getJSONObject("urls").getString("regular"); // Extract image URL
            }

        } catch (IOException | JSONException e) {
            Log.e(TAG, "fetchImageUrl: " + e.getMessage());
        }

        return NO_IMAGE_FOUND;
    }

    public void fetchFoodImages() {
        var ref = db.collection("furniture");
        var getList = imageList();
//        take items from index 55
        for (int i = 0; i < getList.size(); i++) {
            if (i < 55) {
                continue;
            }
            Furniture furniture = getList.get(i);
            String name = furniture.getName();
            String imageUrl = fetchImageUrl(name, furniture.getCategory());
            furniture.setImageUrl(imageUrl);
            var id = ref.document().getId();
            furniture.setPath(id);
            ref.document(id).set(furniture).addOnSuccessListener(aVoid -> Log.d(TAG, "fetchFoodImages: DocumentSnapshot successfully written!")).addOnFailureListener(e -> Log.w(TAG, "fetchFoodImages: Error writing document", e));
            Log.d(TAG, "fetchFoodImages:" + imageUrl);
        }
//        for (Furniture furniture : getList) {
//            String name = furniture.getName();
//            String imageUrl = fetchImageUrlUnsplash(name, furniture.getCategory());
//            furniture.setImageUrl(imageUrl);
//            var id = ref.document().getId();
//            furniture.setPath(id);
//            ref.document(id).set(furniture).addOnSuccessListener(aVoid -> Log.d(TAG, "fetchFoodImages: DocumentSnapshot successfully written!")).addOnFailureListener(e -> Log.w(TAG, "fetchFoodImages: Error writing document", e));
//            Log.d(TAG, "fetchFoodImages:" + imageUrl);
//        }

        Log.d(TAG, "fetchFoodImages: Completed fetching food images");
    }


}