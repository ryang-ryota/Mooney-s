
/**
 * 発注明細行を追加する
 */
function addRow() {
    const $tbody = $('#purchaseOrderItems tbody');
    const $newRow = $tbody.find('tr:first').clone(true);
    const index = $tbody.find('tr').length;

    $newRow.find('input').each(function() {
        const name = $(this).attr('name').replace('[0]', '[' + index + ']');
        $(this).attr('name', name).val('');
    });

    $tbody.append($newRow);
}

/**
 * 指定された発注明細行を削除する
 * @param {HTMLElement} button 削除ボタン要素
 */
function removeRow(button) {
    if ($('#purchaseOrderItems tbody tr').length > 1) {
        $(button).closest('tr').remove();
    }
}