package com.example.teamties.core.essentials.resources
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class StringProviderStore @Inject constructor(
    @PublishedApi
    internal val stringProviders: Map<Class<*>, @JvmSuppressWildcards StringProvider>
) {
    inline operator fun <reified T : StringProvider> invoke(): T {
        return get(T::class.java)
    }
    @Suppress("UNCHECKED_CAST")
    fun <T : StringProvider> get(clazz: Class<T>): T {
        return stringProviders[clazz] as T
    }
}
