package com.zawinski.remote.response

import com.zawinski.remote.models.channel.ChannelRemoteModel

data class ChannelNode(
    val channels: List<ChannelRemoteModel>
)