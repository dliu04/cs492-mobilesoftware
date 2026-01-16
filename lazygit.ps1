Write-Host "Starting script..."
Write-Host "Staging files..."
& git add .
Write-Host "Committing files..."
& git commit -m "Updated: $(Get-Date)"
Write-Host "Attempting to push files to main..."
& git push origin main
Write-Host -NoNewLine 'Done. Press enter to continue...';
$null = Read-Host