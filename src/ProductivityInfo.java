import com.intellij.featureStatistics.CompletionStatistics;
import com.intellij.featureStatistics.FeatureUsageTracker;
import com.intellij.featureStatistics.FeatureUsageTrackerImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * Created by lada on 10.10.16.
 */
public class ProductivityInfo extends AnAction {
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        CompletionStatistics stats = ((FeatureUsageTrackerImpl) FeatureUsageTracker.getInstance()).getCompletionStatistics();
        if (stats.sparedCharacters > 0) {
            Messages.showMessageDialog(project,
                    "Completion saved you from typing " + stats.sparedCharacters + " characters",
                    "Info", Messages.getInformationIcon());
        }
    }
}