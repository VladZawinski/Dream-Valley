package com.zawinski.remote.api

import com.zawinski.remote.response.BaseResponse
import com.zawinski.remote.response.CategoryNode
import com.zawinski.remote.response.ChannelNode
import com.zawinski.remote.response.EpisodeNode

interface PasteBinAPI {
    companion object {
        private const val URL = "https://pastebin.com/raw/"

        private const val NEW_EPISODE = "${URL}z5AExTtw"
        private const val CHANNEL_SECTION = "${URL}Xt12uVhM"
        private const val CATEGORIES_SECTION = "${URL}A0CgArX3"
    }

    suspend fun getNewEpisodes(): BaseResponse<EpisodeNode>

    suspend fun getChannels(): BaseResponse<ChannelNode>

    suspend fun getCategories(): BaseResponse<CategoryNode>


}