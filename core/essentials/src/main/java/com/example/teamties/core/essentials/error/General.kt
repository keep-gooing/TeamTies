package com.example.teamties.core.essentials.error

interface General
sealed interface GeneralError : General {
    data object Network : GeneralError
    data object Server : GeneralError
    data object Unknown : GeneralError
}
