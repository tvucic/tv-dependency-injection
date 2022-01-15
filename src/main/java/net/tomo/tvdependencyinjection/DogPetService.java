package net.tomo.tvdependencyinjection;

public class DogPetService implements PetService
{
    @Override
    public String getPetType()
    {
        return "DogPetService - getPetType()";
    }
}
