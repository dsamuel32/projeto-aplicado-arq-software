package br.com.projetoaplicado.comum.util

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

class ModelMapperConverter(private val modelMapper: ModelMapper = ModelMapper()) {

    private object Holder { val INSTANCE = ModelMapperConverter() }

    companion object {
        val instance: ModelMapperConverter by lazy { Holder.INSTANCE }
    }

    fun converter(source: Any, target: Class<out Any>): Any {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
        return modelMapper.map(source, target)
    }

}