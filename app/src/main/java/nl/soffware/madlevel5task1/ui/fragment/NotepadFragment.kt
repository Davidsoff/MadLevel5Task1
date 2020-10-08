package nl.soffware.madlevel5task1.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_notepad.*
import nl.soffware.madlevel5task1.R
import nl.soffware.madlevel5task1.ui.viewmodel.NoteViewModel

class NotepadFragment : Fragment() {

    companion object {
        fun newInstance() = NotepadFragment()
    }

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notepad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddNoteResult()
    }

    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, {note ->
            note?.let {
                tv_note_title.text = it.title
                tv_note_text.text = it.text
                tv_last_updated.text =
                    getString(R.string.last_updated, it.lastUpdated.toString())
            }
        })
    }

}