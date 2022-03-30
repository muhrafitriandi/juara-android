/**
 * Round tower with multiple stories.
 *
 * @param residents Current number of residents
 * @param radius Radius
 * @param floors Number of stories
 */
class RoundTower(
    residents: Int,
    radius: Double,
    private val floors: Int = 2,
) : RoundHut(
    residents,
    radius
) {
    override val buildingMaterial: String
        get() = "Stone"

    // Capacity depends on the number of floors.
    override val capacity: Int
        get() = 4 * floors

    /**
     * Calculates the total floor area for a tower dwelling
     * with multiple stories.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}