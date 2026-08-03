package com.example.teamties.core.essentials.exceptions.mapper
interface ExceptionToMessageMapper {
    fun getLocalizedMessage(exception: Throwable): String
    companion object : ExceptionToMessageMapper {
        private var instance: ExceptionToMessageMapper = EmptyExceptionToMessageMapper()
        override fun getLocalizedMessage(exception: Throwable): String {
            return instance.getLocalizedMessage(exception)
        }
        fun set(mapper: ExceptionToMessageMapper) {
            this.instance = mapper
        }
        fun reset() {
            instance = EmptyExceptionToMessageMapper()
        }
    }
}
