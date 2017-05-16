package com.example.sophie.gsb2.dummy;

import com.example.sophie.gsb2.Medicament;
import com.example.sophie.gsb2.MedicamentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
   // public  static MedicamentDAO MedAcces = new MedicamentDAO()  ;
    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public  static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();


  //  public  MedicamentDAO getMedAcces() {
   //     return MedAcces;
 //   }

  // public static void setMedAcces(MedicamentDAO medAcces) {
     //   MedAcces = medAcces;
    //}




    public static void ClearIems() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static DummyItem createDummyItem(int position, Medicament unMed) {
        return new DummyItem(String.valueOf(position), unMed.getnom(), makeDetails(unMed));
    }

    private static String makeDetails(Medicament unMed) {
        StringBuilder builder = new StringBuilder();
        builder.append("Prix de l'echantillon: ").append(unMed.getprix()).append("\n").append("\n").append("Contre Indication :").append(unMed.getcontreindic()).append("\n").append("\n").append("Les effets secondaires :").append(unMed.geteffets()).append("\n").append("\n").append("Les composants :").append(unMed.getcomposition());

        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public  static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
