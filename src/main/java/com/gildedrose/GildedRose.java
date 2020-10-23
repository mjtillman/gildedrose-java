package com.gildedrose;

/*
    ======================================
    Gilded Rose Requirements Specification
    ======================================

    Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
    prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
    Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
    have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
    Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
    we can begin selling a new category of items. First an introduction to our system:

    - All items have a SellIn value which denotes the number of days we have to sell the item
    - All items have a Quality value which denotes how valuable the item is
    - At the end of each day our system lowers both values for every item

    Pretty simple, right? Well this is where it gets interesting:

    - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality

    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50

    - "Aged Brie" actually increases in Quality the older it gets
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 after the concert

    We have recently signed a supplier of conjured items. This requires an update to our system:

    - "Conjured" items degrade in Quality twice as fast as normal items

    Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
    still works correctly. However, do not alter the Item class or Items property as those belong to the
    goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
    ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
    for you).

    Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
    legendary item and as such its Quality is 80 and it never alters.
*/

public class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {

    for (Item item : items) {

      String itemName = item.name;

      if (item.quality < 50 && item.quality > 0) {
        switch (itemName) {
          case "Aged Brie":
              updateBrie(item);
            break;
          case "Backstage passes to a TAFKAL80ETC concert":
              updatePass(item);
            break;
          default:
              updateItem(item);
        }
      }

      if (!itemName.contains("Sulfuras")) {
        item.sellIn--;
      }
    }
  }

  public void updateBrie(Item brie) {
    if (brie.sellIn < 0) {
      brie.quality += 2;
    } else {
      brie.quality++;
    }
  }

  public void updatePass(Item pass) {
    if (pass.sellIn < 0) {
      pass.quality = 0;

    } else if (pass.sellIn <= 5) {
      pass.quality *= 3;

    } else if (pass.sellIn <= 10) {
      pass.quality *= 2;

    } else {
      pass.quality++;
    }
  }

  public void updateItem(Item item) {
    if (item.sellIn > 0) {
      item.quality--;
    } else {
      item.quality -= 2;
    }
  }
}