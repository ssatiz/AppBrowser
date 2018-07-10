package satiz.browser

interface AppBrowserView {

    /**
     * Parsing intent data to get the url to load
     */
    fun parseIntentData()

    /**
     * Setup browser to needed settings
     */
    fun setupBrowser()

}