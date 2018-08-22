package br.com.projetoaplicado.cadastro.util

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

class ModelMapperConverter {

    var modelMapper: ModelMapper = ModelMapper()

    fun converter(source: Any, target: Class<out Any>): Any {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
        return modelMapper.map(source, target)
    }

}