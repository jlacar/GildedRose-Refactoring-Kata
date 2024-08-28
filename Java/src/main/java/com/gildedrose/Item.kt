package com.gildedrose

class Item(
    @JvmField val name: String,
    @JvmField var sellIn: Int,
    @JvmField var quality: Int
) {
    override fun toString(): String {
        return "${this.name}, ${this.sellIn}, ${this.quality}"
    }
}
