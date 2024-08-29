package com.gildedrose;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BackstagePassTest {

    @Test
    void quality_drops_to_0_after_concert() {
        var startQuality = 5;
        GildedRose app = new GildedRose(new Item[] {backStagePass(0, startQuality)});

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_increases_by_1_when_sellIn_goes_from_11_to_10() {
        var startQuality = 5;
        GildedRose app = new GildedRose(new Item[] {backStagePass(11, startQuality)});

        app.updateQuality();

        var changeInQuality = app.items[0].quality - startQuality;
        assertEquals(1, changeInQuality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void quality_increases_by_2_when_sellIn_goes_from_6_to_5() {
        var startQuality = 10;
        GildedRose app = new GildedRose(new Item[] {backStagePass(6, startQuality)});

        app.updateQuality();

        var changeInQuality = app.items[0].quality - startQuality;
        assertEquals(2, changeInQuality);
        assertEquals(5, app.items[0].sellIn);
    }

    @ParameterizedTest(name = "Sell in {0} days: quality increases by 1")
    @ValueSource(ints = {20, 15, 12, 11})
    void quality_increases_by_1_when_concert_is_more_than_ten_days_away(int sellIn) {
        int startQuality = 5;
        Item[] items = new Item[]{
            backStagePass(sellIn, startQuality)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int changeInQuality = app.items[0].quality - startQuality;
        assertEquals(1, changeInQuality, "Unexpected change in quality");
    }

    @ParameterizedTest(name = "Sell in {0} days: quality increases by 2")
    @ValueSource(ints = {10, 9, 8, 7, 6})
    void quality_increases_by_2_when_ten_days_or_less_before_concert(int sellIn) {
        int startQuality = 5;
        Item[] items = new Item[]{
            backStagePass(sellIn, startQuality)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int changeInQuality = app.items[0].quality - startQuality;
        assertEquals(2, changeInQuality, "Unexpected change in quality");
    }

    @ParameterizedTest(name = "Sell in {0} days: quality increases by 3")
    @ValueSource(ints = {5, 4, 3, 2, 1})
    void quality_increases_by_3_when_five_days_or_less_before_concert(int sellIn) {
        int startQuality = 5;
        Item[] items = new Item[]{
            backStagePass(sellIn, startQuality)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int changeInQuality = app.items[0].quality - startQuality;
        assertEquals(3, changeInQuality, "Unexpected change in quality");
    }

    private Item backStagePass(int sellIn, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
}
