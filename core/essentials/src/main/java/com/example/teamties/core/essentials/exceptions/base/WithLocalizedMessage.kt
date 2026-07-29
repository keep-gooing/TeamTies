package com.example.teamties.core.essentials.exceptions.base

import com.example.teamties.core.essentials.resources.StringProviderStore


interface WithLocalizedMessage {

    
    fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String
}
