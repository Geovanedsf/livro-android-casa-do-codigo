package tech.salvatore.livro_android_kotlin_paulo_salvatore.view.creatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import tech.salvatore.livro_android_kotlin_paulo_salvatore.R
import tech.salvatore.livro_android_kotlin_paulo_salvatore.databinding.CreatureAddedFragmentBinding
import tech.salvatore.livro_android_kotlin_paulo_salvatore.viewmodel.CreaturesViewModel

@AndroidEntryPoint
class CreatureAddedFragment : Fragment() {
    private lateinit var binding: CreatureAddedFragmentBinding

    private val viewModel: CreaturesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            CreatureAddedFragmentBinding.inflate(
                layoutInflater,
                container,
                false
            )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: CreatureAddedFragmentArgs by navArgs()
        val creatureId = safeArgs.creatureNumber

        // Find Creature
        val creature = viewModel.findCreature(creatureId)
        binding.creature = creature

        // See creature in list
        val btAddCreature = view.findViewById<Button>(R.id.btAddCreature)
        btAddCreature.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
