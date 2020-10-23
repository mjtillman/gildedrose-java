package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void normalItemOneDay() {
        Item[] items = new Item[] { new Item("Milk", 20, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(39, app.items[0].quality);
    }

    @Test
    void normalItemAtSellInDate() {
        Item[] items = new Item[] { new Item("Milk", 15, 40) };
        GildedRose app = new GildedRose(items);
        for (int i = 15; i > 0; i--) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].sellIn);
        assertEquals(25, app.items[0].quality);
    }

    @Test
    void normalItemPastSellInDate() {
        Item[] items = new Item[] { new Item("Milk", 15, 40) };
        GildedRose app = new GildedRose(items);
        for (int i = 15; i > -5; i--) {
            app.updateQuality();
        }
        assertEquals(-5, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }

}
